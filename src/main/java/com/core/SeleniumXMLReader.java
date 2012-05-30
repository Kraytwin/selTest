package com.core;

import java.util.ArrayList;

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SeleniumXMLReader extends DefaultHandler {

  private boolean isPart = false;
  private String attributeName = "";
  private String methodType, part;
  private ArrayList<String> parts = new ArrayList<String>( );
  private ArrayList<NavigationUnit> navUnits;
  private NavigationUnitControl seq;
  private NavigationUnit navUnit;
  private String custMethodPrefix = "";

  public SeleniumXMLReader( NavigationUnitControl seqIn ) {
    seq = seqIn;
    this.navUnits = new ArrayList<NavigationUnit>( );
  }

  // XXX This isn't really needed anymore but may be incorporated in again.
  public void comment( char[ ] text, int start, int length ) throws SAXException {

    String comment = new String( text, start, length );
    System.out.println( comment );

  }

  public void startElement( String uri, String localName, String rawName, Attributes attributes ) {
    if ( rawName.equals( "Sequence" ) ) {
      custMethodPrefix = attributes.getValue( "name" );
      if ( custMethodPrefix == null ) {
        custMethodPrefix = "none";
      }
      if ( attributes.getValue( "URL" ) != null ) {
        seq.setURL( attributes.getValue( "URL" ) );
      }
      seq.setCustomMethodPrefix( custMethodPrefix );
    } else if ( rawName.equals( "NavigationUnit" ) ) {
      // If "name" does not exist then there is something wrong
      // XXX Deal with the above issue of invalid XML.
      attributeName = attributes.getValue( "name" );
      isPart = false;
      navUnit = new NavigationUnit( attributeName );
      // Need to get the name attribute, this will be the suffix for any files generated from this
      // step later
      // This relates to the custom methods of screenshots, validation, etc.
    } else if ( rawName.equals( "MethodName" ) ) {
      methodType = attributes.getValue( "type" );
      isPart = false;
      // Since this is a new method then the parts arraylist needs to be cleared.
      parts = new ArrayList<String>( );
      // The potential null values will not be dealt with here but at the endElement section
    } else if ( rawName.equals( "Part" ) ) {
      isPart = true;
      // need to make sure the string starts off empty.
      part = "";
    } else {
      System.out.println( "Element not recognised" );
    }
  }

  public void endElement( String namespaceURI, String localName, String Name ) {
    if ( Name.equals( "Sequence" ) ) {
      // Should be the end of entire document
      // XXX Need to output that it is fully read maybe with a count of how many navunits there are.
    } else if ( Name.equals( "NavigationUnit" ) ) {
      // NavUnit should be complete now.
      navUnits.add( navUnit );
      // Should output that the navunit has been added
    } else if ( Name.equals( "MethodName" ) ) {
      SeleniumMethod m;
      if ( parts.isEmpty( ) ) {
        m = new SeleniumMethod( methodType );
      } else {
        String[ ] partArray = this.convertArrayListToStringArray( parts );
        m = new SeleniumMethod( methodType, partArray );
      }
      navUnit.addMethod( m );
    } else if ( Name.startsWith( "Part" ) ) {
      // When the string has been fully created then it can be added.
      parts.add( part );
      // Need to stop the whitespace between the characters being added.
      isPart = false;
    } else {
      System.out.println( "Element not recognised" );
    }
  }

  private String[ ] convertArrayListToStringArray( ArrayList<String> partIn ) {
    String[ ] partArray = new String[ partIn.size( ) ];
    for ( int i = 0; i < partArray.length; i++ ) {
      partArray[ i ] = partIn.get( i );
    }
    return partArray;
  }

  public void endDocument( ) {

  }

  public void characters( char[ ] ch, int start, int length ) throws SAXException {
    if ( isPart ) {
      String s = new String( ch, start, length );
      // Part has been set to a blank string before it has reached here; it needs to be concatenated
      // since
      // it doesn't necessarily print out the entire string each time
      part += s;
    }
  }

  public void ignorableWhitespace( char ch[], int start, int length ) {
    // This is ignorable, so don't display it
  }

  // do-nothing methods not needed here
  public void startDTD( String name, String publicId, String systemId ) throws SAXException {
  }

  public void endDTD( ) throws SAXException {
  }

  public void startEntity( String name ) throws SAXException {
  }

  public void endEntity( String name ) throws SAXException {
  }

  public void startCDATA( ) throws SAXException {
  }

  public void endCDATA( ) throws SAXException {
  }

}