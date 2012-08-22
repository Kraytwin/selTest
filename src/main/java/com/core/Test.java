package com.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Test {

  private boolean isValid = false;
  private File testFile, schema;
  private XMLReader parser;
  private String errors, url;
  private ConfigSettings config = ConfigSettings.getInstance( );

  public Test( File fileIn ) {
    try {
      schema = new File( config.getClass( ).getClassLoader( ).getResource( "XMLSchema.xsd" ).toURI( ) );
    } catch ( URISyntaxException e1 ) {
      schema = new File( config.getClass( ).getClassLoader( ).getResource( "XMLSchema.xsd" ).getPath( ) );
    }
    url = this.config.getProperty( "GENERAL.DEFAULT_IP" );
    testFile = fileIn;
    try {
      parser = XMLReaderFactory.createXMLReader( );
    } catch ( SAXException e ) {
      System.err.println( "Error: could not locate a parser." );
    }
    /*
     * Going to check that it matches the schema first, then get the details from it.
     * It will be checked that it is valid
     */
    if ( this.validateAgainstSchema( ) ) {
      this.buildTest( );
    }
  }

  private boolean buildTest( ) {
    // Since it validates against the schema we can now get details from it
    try {
      // Using the default URL, this will then become the URL from the test if it is valid and has
      // one
      NavigationUnitControl nuc = new NavigationUnitControl( url );
      DefaultHandler handler = new SeleniumXMLReader( nuc );
      parser.setContentHandler( handler );
      parser.parse( testFile.getAbsolutePath( ) );
      return true;
    } catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
      return false;
    } catch ( SAXParseException e ) {
      errors = e.getMessage( ) + " at line " + e.getLineNumber( ) + ", column " + e.getColumnNumber( );
      return false;
    } catch ( SAXException e ) {
      e.printStackTrace( );
      return false;
    }

  }

  private boolean validateAgainstSchema( ) {
    return false;
  }

  public boolean isTestValid( ) {
    // TODO Auto-generated method stub
    return false;
  }

}
