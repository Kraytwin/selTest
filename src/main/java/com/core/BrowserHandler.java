package com.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class BrowserHandler {

  private File location;

  public BrowserHandler( File locationIn ) {
    this.location = locationIn;
  }

  public ArrayList<Browser> readBrowsers( ) {
    ArrayList<Browser> browsers = new ArrayList<Browser>( );

    try {
      CSVReader in = new CSVReader( new FileReader( location ) );
      String[ ] nextLine;
      while ( ( nextLine = in.readNext( ) ) != null ) {
        if ( nextLine.length > 0 ) {
          if ( nextLine.length == 3 ) {
            browsers.add( new Browser( nextLine[ 0 ], nextLine[ 1 ], nextLine[ 2 ] ) );
          } else if ( nextLine.length == 5 ) {
            browsers.add( new Browser( nextLine[ 0 ], nextLine[ 1 ], nextLine[ 2 ], nextLine[ 3 ], nextLine[ 4 ] ) );
          } else {
            System.out.println( "Incorrect number of attributes for browser" );
          }
        } else {
          System.out.println( "Browser has no attributes" );
        }
      }
    } catch ( FileNotFoundException e ) {
      e.printStackTrace( );
    } catch ( IOException e ) {
      e.printStackTrace( );
    }

    return browsers;
  }

}
