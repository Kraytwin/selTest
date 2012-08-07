package com.core;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class XMLCreator {

  /**
   * @param args
   */
  public static void main( String[ ] args ) {
    // TODO Auto-generated method stub
    File dir = new File( "/Users/stephenfallis/Desktop/Selenium/Selenium_Integration_Paths/" );
    File[ ] files = dir.listFiles( );
    for ( File fileIn : files ) {
      if ( !fileIn.getName( ).equals( ".DS_Store" ) ) {
        File fileOut = new File( fileIn.getPath( ).replace( ".txt", ".xml" ) );
        SeleniumXMLGenerator xml = new SeleniumXMLGenerator( fileIn, fileOut, "http://10.0.0.32" );
        xml.SeleniumXMLOutput( );
      }
    }
  }

}
