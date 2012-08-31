package com.core;

import java.io.File;

public class YAMLCreator {

  public static void main( String[ ] args ) {
    File dir = new File( "/Users/stephenfallis/Desktop/Selenium/Selenium_Integration_Paths/" );
    File[ ] files = dir.listFiles( );
    for ( File fileIn : files ) {
      if ( !fileIn.getName( ).equals( ".DS_Store" ) && fileIn.getName( ).endsWith( ".txt" ) ) {
        File fileOut = new File( fileIn.getPath( ).replace( ".txt", ".yaml" ) );
        SeleniumYAMLGenerator yaml = new SeleniumYAMLGenerator( fileIn, fileOut, "http://10.0.0.32" );
        yaml.SeleniumYAMLOutput( );
      }
    }
  }
}
