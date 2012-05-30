package com.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import nslib.util.NSXML.XMLException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A utility class to allow properties to be loaded from XML files, easily
 * accessed and set, and then saved in XML format.
 * 
 * In its simplest form, properties can be gotten and set by simply calling the
 * appropriate get/set methods. Configuration can be persisted between sessions
 * by calling the load/save methods. Properties are case sensitive.
 * 
 * This class also provides more advanced grouping options using dot notation.
 * To specify a group, use a key of the form group.property in the appropriate
 * get/set methods. For example, group1.aProperty is not the same as
 * group2.aProperty.
 * 
 * It is possible to combine grouped and none grouped property settings in the
 * same configuration (so specifying Aproperty and group1.Aproperty and
 * group2.Aproperty will result in 3 unique properties)
 * 
 * Comments can be associated with both individual properties and groups using
 * the appropriate get/set comment methods
 * 
 * @author James Philipps
 * 
 */
public class ConfigSettings {

  public static void main( String[ ] args ) {
    ConfigSettings config = ConfigSettings.getInstance( );
    try {
      config.loadConfig( new File(
          "/Users/stephenfallis/work/eclipse-workspace/lhaupdater/src/main/resources/lhaupdater_config.xml" ) );
    } catch ( ConfigurationException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace( );
    } catch ( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace( );
    }

    Iterator<ConfigProperty> i = config.getPropertyIterator( );
    while ( i.hasNext( ) ) {
      System.out.println( i.next( ) );
    }
    config.setWriteBlankElements( false );
    // System.exit( 0 );
    config.setProperty( "test", "" );
    config.setProperty( "REGEX.PROPERTY_PREFIX_REGEX", "^\\s*<PackageProperty\\s+name=\"" );
    config
        .setProperty( "REGEX.PROPERTY_SUFFIX_REGEX", "\"\\s*><!\\[CDATA\\[\\s*(.*)\\s*\\]\\]></PackageProperty>\\s*$" );
    config.setProperty( "REGEX.PROPERTY_PREFIX", "    <PackageProperty name=\"" );
    config.setProperty( "REGEX.PROPERTY_MIDDLE", "\"><![CDATA[ " );
    config.setProperty( "REGEX.PROPERTY_SUFFIX", " ]]></PackageProperty>\n" );
    config.setProperty( "REGEX.ATTR_ENABLE_LHA_RULES",
        "<ITEM NAME=\"ENABLE_LHA_RULES\" TYPE=\"ATTRIBUTE\" USAGE=\"QUESTION\" DATATYPE=\"BOOLEAN\">" );
    config.setProperty( "REGEX.ATTR_ENABLE_LHA_POSTCODES",
        "<ITEM NAME=\"ENABLE_LHA_POSTCODES\" TYPE=\"ATTRIBUTE\" USAGE=\"QUESTION\" DATATYPE=\"BOOLEAN\">" );
    config.setProperty( "REGEX.ATTR_LHA_AREAS_INFO",
        "<ITEM NAME=\"LHA_AREAS_INFO\" TYPE=\"ATTRIBUTE\" USAGE=\"QUESTION\" DATATYPE=\"TABLE\">" );
    config.setProperty( "REGEX.ATTR_LHA_RATES_INFO",
        "<ITEM NAME=\"LHA_RATES_INFO\" TYPE=\"ATTRIBUTE\" USAGE=\"QUESTION\" DATATYPE=\"TABLE\">" );

    try {
      config.saveConfig( new File(
          "/Users/stephenfallis/work/eclipse-workspace/lhaupdater/src/main/resources/lhaupdater_config.xml" ) );
    } catch ( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    } catch ( ConfigurationException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    }
  }
  /**
   * Singleton instance of the class
   */
  private static ConfigSettings instance;

  /**
   * The name given to the default group for properties without groups
   */
  private static String defaultGroupName = "DefaultGroup";

  /**
   * The name of the root element of the xml document
   */
  private static String rootElem = "Config";

  /**
   * The currently loaded configuration file
   */
  private File currentConfigFile = null;

  /**
   * The default group to hold properties not included in other groups
   */
  private ConfigGroup defaultGroup;

  /**
   * Whether or not to write elements with no value to the config file
   */
  private boolean writeBlankElements = false;

  /**
   * Groups containing properties
   */
  private ArrayList<ConfigGroup> groups;

  /**
   * Private constructor to prevent initialisation outside the class
   */
  private ConfigSettings( ) {
    this.init( );
  }

  /**
   * Clears all previous config options and sets up a new blank config object
   */
  private void init( ) {
    groups = new ArrayList<ConfigGroup>( );
    defaultGroup = new ConfigGroup( defaultGroupName );
    groups.add( defaultGroup );
  }

  /**
   * Returns an instance of the config settings
   * 
   * @return An instance of the config settings
   */
  public static ConfigSettings getInstance( ) {
    if ( instance == null ) {
      instance = new ConfigSettings( );
    }
    return instance;
  }

  /**
   * Set a property. Use dot notation to access groups (group1.property2)
   * 
   * @param name
   *          Name of the property
   * @param value
   *          Value to set the property to
   */
  public void setProperty( String name, String value ) {
    setProperty( name, value, "" );
  }

  /**
   * Set a property. Use dot notation to access groups (group1.property2)
   * 
   * @param name
   *          Name of the property
   * @param value
   *          Value to set the property to
   * @param comment
   *          Comment associated with the property
   */
  public void setProperty( String name, String value, String comment ) {
    ConfigGroup cg = getConfigGroupFromKey( name );
    ConfigProperty c = cg.getProperty( name );

    if ( c == null ) {
      c = new ConfigProperty( name, cg.getGroupName( ), "" );
      cg.addProperty( c );
    }

    c.setComment( comment );
    c.setValue( value );
  }

  /**
   * Set a comment associated with a property. Use dot notation to access groups
   * (group1.property2)
   * 
   * @param name
   *          Name of the property
   * @param comment
   *          Comment associated with the property
   */
  public void setPropertyComment( String name, String comment ) {
    ConfigGroup cg = getConfigGroupFromKey( name );
    ConfigProperty c = cg.getProperty( name );

    if ( c == null ) {
      c = new ConfigProperty( name, cg.getGroupName( ), "" );
      cg.addProperty( c );
    }

    c.setComment( comment );
  }

  /**
   * Get a property. Use dot notation to access groups (group1.property2)
   * 
   * @param name
   *          Name of the property
   * 
   * @return The property, or null if the property was not found
   */
  public String getProperty( String name ) {
    ConfigGroup cg = getConfigGroupFromKey( name );

    ConfigProperty c;
    if ( name.contains( "." ) ) {
      c = cg.getProperty( name.substring( name.lastIndexOf( "." ) + 1 ) );
    } else {
      c = cg.getProperty( name );
    }
    return c != null ? c.getValue( ) : null;
  }

  /**
   * Get a comment associated with a property. Use dot notation to access groups
   * (group1.property2)
   * 
   * @param name
   *          Name of the property
   * 
   * @return The comment, or null if the associated property was not found
   */
  public String getPropertyComment( String name ) {
    ConfigGroup cg = getConfigGroupFromKey( name );

    ConfigProperty c;
    if ( name.contains( "." ) ) {
      c = cg.getProperty( name.substring( name.lastIndexOf( "." ) + 1 ) );
    } else {
      c = cg.getProperty( name );
    }

    return c != null ? c.getComment( ) : null;
  }

  /**
   * Sets a comment associated with a particular group
   * 
   * @param groupName
   *          The name of the group
   * @param comment
   *          The comment
   */
  public void setGroupComment( String groupName, String comment ) {
    ConfigGroup cg = getConfigGroup( groupName );
    if ( cg != null ) {
      cg.setGroupComment( comment );
    }
  }

  /**
   * Sets a comment associated with a particular group
   * 
   * @param groupName
   *          The name of the group
   * @return The comment, or null if the associated group was not found
   */
  public String getGroupComment( String groupName ) {
    ConfigGroup cg = getConfigGroup( groupName );
    return cg == null ? null : cg.getGroupComment( );
  }

  public Iterator<ConfigProperty> getPropertyIterator( ) {
    ArrayList<ConfigProperty> allProps = new ArrayList<ConfigProperty>( );
    Iterator<ConfigGroup> ig = groups.iterator( );
    while ( ig.hasNext( ) ) {
      ConfigGroup cg = ig.next( );
      Iterator<ConfigProperty> ip = cg.getPropertyIterator( );
      while ( ip.hasNext( ) ) {
        allProps.add( ip.next( ) );
      }
    }

    return allProps.iterator( );
  }

  /**
   * Loads the configuration options from an XML file
   * 
   * @param configFile
   *          The file to load from
   */
  public void loadConfig( File configFile ) throws ConfigurationException, IOException {
    Document doc = parseDocument( configFile );
    Element root = doc.getDocumentElement( );

    // reset config
    this.init( );

    // Deal with default group settings
    buildConfigGroup( defaultGroup, root );

    // Deal with property groups. Can't getTagaByName here as we need to capture
    // comment nodes too, so we'll have to filter out the unwanted ones
    NodeList rootNodes = root.getChildNodes( );
    String prevComment = null;
    for ( int i = 0; i < rootNodes.getLength( ); i++ ) {
      // // Filter unwanted nodes
      // if ( rootNodes.item( i ).getNodeName( ).compareTo(
      // ConfigProperty.elementName ) == 0 ) {
      // continue;
      // }

      if ( rootNodes.item( i ).getNodeType( ) == Node.COMMENT_NODE ) {
        prevComment = rootNodes.item( i ).getTextContent( );
      } else if ( rootNodes.item( i ).getNodeType( ) == Node.ELEMENT_NODE ) {
        if ( rootNodes.item( i ).getNodeName( ).compareTo( ConfigGroup.groupElem ) == 0 ) {
          Element cge = ( Element ) rootNodes.item( i );
          ConfigGroup cg = new ConfigGroup( cge.getAttribute( "id" ) );
          if ( prevComment != null ) {
            cg.setGroupComment( prevComment );
            prevComment = null;
          }

          buildConfigGroup( cg, cge );
          groups.add( cg );
        }
      }
    }

    currentConfigFile = configFile;
  }

  /**
   * Builds a group from a given set of property nodes
   * 
   * @param cg
   *          The group to add the properties to
   * @param groupNode
   *          The node containing the property nodes
   */
  private void buildConfigGroup( ConfigGroup cg, Element groupNode ) {
    NodeList properties = groupNode.getChildNodes( );
    String prevComment = null;
    for ( int i = 0; i < properties.getLength( ); i++ ) {
      if ( properties.item( i ).getNodeType( ) == Node.ELEMENT_NODE ) {
        if ( properties.item( i ).getNodeName( ).compareTo( ConfigProperty.elementName ) == 0 ) {
          Element e = ( Element ) properties.item( i );
          ConfigProperty p = new ConfigProperty( e.getAttribute( "id" ), cg.getGroupName( ), e.getTextContent( ) );

          // If a previous comment was found, use it and null it
          if ( prevComment != null ) {
            p.setComment( prevComment );
            prevComment = null;
          }

          cg.addProperty( p );
        }
      } else if ( properties.item( i ).getNodeType( ) == Node.COMMENT_NODE ) {
        prevComment = properties.item( i ).getTextContent( );
      }
    }
  }

  /**
   * Parse an XML file to a Document object
   * 
   * @param f
   *          The file to parse
   * @return A Document object representing the file
   * @throws XMLException
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  private Document parseDocument( File f ) throws ConfigurationException {
    try {
      InputSource is = new InputSource( );
      is.setCharacterStream( new FileReader( f ) );
      DocumentBuilder db = DocumentBuilderFactory.newInstance( ).newDocumentBuilder( );

      return db.parse( is );
    } catch ( Exception e ) {
      throw new ConfigurationException( "Problem Parsing XML Document: \n" + e.toString( ) );
    }
  }

  /**
   * Saves an XML Document object to an XML text file
   * 
   * @param doc
   *          The document to save
   * @param f
   *          The file to save to
   * @throws TransformerException
   */
  private void saveDocToFile( Document doc, File f ) throws TransformerException, FileNotFoundException {
    TransformerFactory tf = TransformerFactory.newInstance( );
    tf.setAttribute( "indent-number", new Integer( 2 ) );

    Transformer xformer = tf.newTransformer( );
    xformer.setOutputProperty( OutputKeys.INDENT, "yes" );

    xformer.transform( new DOMSource( doc ), new StreamResult( new OutputStreamWriter( new FileOutputStream( f ) ) ) );
  }

  /**
   * Saves the configuration options to an XML file
   * 
   * @param configFile
   *          The file to save to
   */
  public void saveConfig( File configFile ) throws ConfigurationException, FileNotFoundException {
    try {
      Document d = DocumentBuilderFactory.newInstance( ).newDocumentBuilder( ).newDocument( );
      Element root = d.createElement( ConfigSettings.rootElem );
      d.appendChild( root );

      // Sort config Groups
      Collections.sort( groups );

      // Add items from default group directly to the config.
      buildPropertyGroupNode( getConfigGroupFromKey( defaultGroupName ).getPropertyIterator( ), root, d );

      // Create Group nodes and add properties to them
      Iterator<ConfigGroup> icg = groups.iterator( );
      while ( icg.hasNext( ) ) {
        ConfigGroup cg = icg.next( );

        // Don't add stuff in the default grouping - it has already been added
        if ( cg.getGroupName( ).compareTo( defaultGroupName ) == 0 ) {
          continue;
        }

        // Append group comment to doc
        if ( cg.getGroupComment( ).length( ) > 0 ) {
          root.appendChild( d.createComment( cg.getGroupComment( ) ) );
        }

        // Create group node
        Element cgNode = d.createElement( ConfigGroup.groupElem );
        cgNode.setAttribute( "id", cg.getGroupName( ) );
        root.appendChild( cgNode );

        // Add group properties to group node
        buildPropertyGroupNode( cg.getPropertyIterator( ), cgNode, d );
      }

      saveDocToFile( d, configFile );
    } catch ( DOMException e ) {
      throw new ConfigurationException( e );
    } catch ( ParserConfigurationException e ) {
      throw new ConfigurationException( e );
    } catch ( TransformerException e ) {
      throw new ConfigurationException( e );
    }
  }

  /**
   * Build a property group node from a property group
   * 
   * @param propertyIterator
   *          An iterator for the properties in a group
   * @param appendNode
   *          The node to append the properties to
   * @param d
   *          The document (used to create new nodes only)
   */
  private void buildPropertyGroupNode( Iterator<ConfigProperty> propertyIterator, Element appendNode, Document d ) {
    while ( propertyIterator.hasNext( ) ) {
      ConfigProperty p = propertyIterator.next( );

      // Check if we're still writing blank elements
      if ( ( !writeBlankElements ) && ( p.getValue( ).length( ) == 0 ) ) {
        continue;
      }

      if ( ( p.getComment( ) != null ) && ( p.getComment( ).length( ) > 0 ) ) {
        appendNode.appendChild( d.createComment( p.getComment( ) ) );
      }

      Element ep = d.createElement( ConfigProperty.elementName );
      ep.setAttribute( "id", p.getName( ) );
      ep.appendChild( d.createCDATASection( p.getValue( ) ) );
      appendNode.appendChild( ep );
    }
  }

  /**
   * Get a config group based on a key which can be in the form group.property
   * or property. In cases where no group is specified, the default group is
   * returned. If a specified group does not exist, it will be created.
   * 
   * @param elementKey
   *          The key to use for search
   * @return The config group (a group will always be returned as not-found
   *         groups are created)
   */
  private ConfigGroup getConfigGroupFromKey( String elementKey ) {
    String groupName;
    if ( elementKey.contains( "." ) ) {
      groupName = elementKey.substring( 0, elementKey.lastIndexOf( "." ) );
    } else {
      groupName = defaultGroupName;
    }

    return getOrCreateConfigGroup( groupName );
  }

  /**
   * Searches for a specified group, and creates it if it is not found
   * 
   * @param groupName
   *          The name of the group (NOTE: this must be an exact name, not a
   *          name of the form group.property)
   * @return The config group (a group will always be returned as not-found
   *         groups are created)
   */
  private ConfigGroup getOrCreateConfigGroup( String groupName ) {
    ConfigGroup foundGroup = getConfigGroup( groupName );
    if ( foundGroup == null ) {
      foundGroup = new ConfigGroup( groupName );
      groups.add( foundGroup );
    }
    return foundGroup;
  }

  /**
   * Searches for a specified group.
   * 
   * @param groupName
   *          The name of the group (NOTE: this must be an exact name, not a
   *          name of the form group.property)
   * @return The config group, or null if no group is found
   */
  private ConfigGroup getConfigGroup( String groupName ) {
    Iterator<ConfigGroup> i = groups.iterator( );
    while ( i.hasNext( ) ) {
      ConfigGroup cg = i.next( );
      if ( cg.getGroupName( ).compareTo( groupName ) == 0 ) {
        return cg;
      }
    }
    return null;
  }

  /**
   * Set the name of the root element of the config document (when saved)
   * 
   * @param rootElem
   *          The name of the element
   */
  public void setRootElem( String rootElem ) {
    ConfigSettings.rootElem = rootElem;
  }

  /**
   * Set the name of the child elements of the config document (when saved)
   * 
   * @param childElem
   *          The name of the element
   */
  public void setChildElem( String childElem ) {
    ConfigProperty.setElementName( childElem );
  }

  /**
   * 
   * Returns the currently loaded configuration file, or null if none is loaded
   * 
   * @return A File
   */

  public File getCurrentConfigFile( ) {
    return currentConfigFile;
  }

  /**
   * Set whether or not to write elements with no value to the xml file
   * 
   * @param writeBlankElements
   *          True if enabling writing blank properties to the file
   */
  public void setWriteBlankElements( boolean writeBlankElements ) {
    this.writeBlankElements = writeBlankElements;
  }

  public static class ConfigurationException extends Exception {

    private static final long serialVersionUID = -3923709950738116549L;

    public ConfigurationException( ) {
      super( );
    }

    public ConfigurationException( String arg0, Throwable arg1 ) {
      super( arg0, arg1 );
    }

    public ConfigurationException( String arg0 ) {
      super( arg0 );
    }

    public ConfigurationException( Throwable arg0 ) {
      super( arg0 );
    }
  }

  /**
   * Represents a grouping of configuration options with a name and associated
   * comment
   * 
   * @author jamesphilipps
   * 
   */
  private static class ConfigGroup implements Comparable<ConfigGroup> {

    /**
     * The name of the group element of the config document
     */
    private static String groupElem = "ConfigGroup";

    /**
     * The name of the group
     */
    private String groupName;

    /**
     * The comment associated with the group
     */
    private String groupComment = "";

    private Hashtable<String, ConfigProperty> properties = new Hashtable<String, ConfigProperty>( );

    public ConfigGroup( String groupName ) {
      this.groupName = groupName;
    }

    public void addProperty( ConfigProperty c ) {
      properties.put( c.getName( ), c );
    }

    public ConfigProperty getProperty( String name ) {
      return properties.get( name );
    }

    public String getGroupName( ) {
      return groupName;
    }

    @SuppressWarnings("unused")
    public void setGroupName( String groupName ) {
      this.groupName = groupName;
    }

    public String getGroupComment( ) {
      return groupComment;
    }

    public void setGroupComment( String groupComment ) {
      this.groupComment = groupComment;
    }

    /**
     * Returns an iterator over all property elements in this group, in order
     * 
     * @return
     */
    public Iterator<ConfigProperty> getPropertyIterator( ) {
      Iterator<ConfigProperty> i = properties.values( ).iterator( );

      // Sort config options
      TreeSet<ConfigProperty> ts = new TreeSet<ConfigProperty>( );
      while ( i.hasNext( ) ) {
        ts.add( i.next( ) );
      }

      return ts.iterator( );
    }

    public int compareTo( ConfigGroup o ) {
      return groupName.compareTo( o.groupName );
    }

    @Override
    public String toString( ) {
      StringBuilder sb = new StringBuilder( );
      sb.append( "ConfigGroup [name=" + groupName + ", comment=" + groupComment + "\n" );
      Iterator<ConfigProperty> i = getPropertyIterator( );
      while ( i.hasNext( ) ) {
        ConfigProperty p = i.next( );
        sb.append( p.toString( ) + "\n" );
      }
      return sb.toString( );
    }
  }

  /**
   * A class representing a configuration property with associated comment
   * 
   * @author jamesphilipps
   * 
   */
  public static class ConfigProperty implements Comparable<ConfigProperty> {

    private static String elementName = "ConfigSetting";

    private String name;
    private String value;
    private String comment;
    private String group;

    public ConfigProperty( String name, String group, String value ) {
      super( );
      setName( name );
      this.value = value;
      this.group = group;
      this.comment = null;
    }

    public static String getElementName( ) {
      return elementName;
    }

    public static void setElementName( String elementName ) {
      ConfigProperty.elementName = elementName;
    }

    public String getName( ) {
      return name;
    }

    public void setName( String name ) {
      if ( name.contains( "." ) ) {
        this.name = name.substring( name.lastIndexOf( "." ) + 1 );
      } else {
        this.name = name;
      }
    }

    public String getValue( ) {
      return value;
    }

    public void setValue( String value ) {
      this.value = value;
    }

    public String getComment( ) {
      return comment;
    }

    public void setComment( String comment ) {
      this.comment = comment;
    }

    public int compareTo( ConfigProperty c ) {
      return this.name.compareTo( c.getName( ) );
    }

    @Override
    public String toString( ) {
      return "ConfigProperty [name=" + name + ", group=" + group + ", value=" + value + "comment=" + comment + "]";
    }

    public String getGroup( ) {
      return group;
    }

    public void setGroup( String group ) {
      this.group = group;
    }

  }

}
