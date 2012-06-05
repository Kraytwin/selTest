package com.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SeleniumMain {

  // XXX Will need to be changed, remove hard coding.
  // XXX This will now need to deal with running the start selenium method and getting the config;
  // also talking to the controller to get items from the UI.
  public static void main( String[ ] args ) {

    // set up the parser
    XMLReader parser;
    try {
      parser = XMLReaderFactory.createXMLReader( );
    } catch ( SAXException e ) {
      System.err.println( "Error: could not locate a parser." );
      return;
    }
    // Only for now as these will be taken from a browser XML file.
    ArrayList<Browser> browsers = new ArrayList<Browser>( );
    // browsers.add( new Browser(
    // "Safari","safari","/Applications/Safari.app/Contents/MacOS/Safari","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    browsers.add( new Browser( "Firefox3.6", "chrome", "/Applications/Firefox3.6.app/Contents/MacOS/firefox-bin",
        "127.0.0.1", "/Users/stephenfallis/Desktop/random/" ) );

    BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );

    try {
      // XXX Remove this once an interface goes in place
      System.out.println( "Enter the path to read: " );
      String path = in.readLine( );
      System.out.println( "Enter the starting URL: " );
      String url = in.readLine( );
      // Soon this will become the default URL from the config
      NavigationUnitControl nuc = new NavigationUnitControl( url );
      DefaultHandler handler = new SeleniumXMLReader( nuc );
      parser.setContentHandler( handler );
      // start parsing...
      parser.parse( path );
      for ( Browser browser : browsers ) {
        // This will all probably be moved into a different method soon.
        nuc.runNavSequence( browser );
      }

      /*
       * Actual order of working here is start Selenium, call class that overviews nav
       * run each NavUnit and corresponding special class.
       * close Selenium,
       * restart for each browser. This is all now handles in NavigationUnitControl
       * When the GUI is built then this will change quite a bit.
       */
    } catch ( SAXParseException e ) { // well-formedness error
      System.out.println( e.getMessage( ) + " at line " + e.getLineNumber( ) + ", column " + e.getColumnNumber( ) );
    } catch ( SAXException e ) { // some other kind of error
      System.out.println( e.getMessage( ) );
    } catch ( IOException e ) {
      System.out.println( "Could not read " + " because of the IOException " );
      e.printStackTrace( );
    }

  }
  
  public ArrayList<Browser> getBroswers(  ) {
	  return null;
  }
  
  public ArrayList<String> getSites( ) {
	  return null;
  }
  
  public ArrayList<String> getTests( ) {
	  return null;
  }

}
