package com.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is where the sitelist is built up and maintained.
 * Sites can be added/removed individually or read from a file.
 * 
 * @author stephenfallis
 * 
 */
public class SiteList {

  private ArrayList<String> sites;

  public SiteList( File file ) {
    sites = new ArrayList<String>( );
    this.readSites( file );
  }

  public SiteList( ) {
    sites = new ArrayList<String>( );
  }

  public ArrayList<String> getSiteList( ) {
    return sites;
  }

  public boolean addSite( String site ) {
    // XXX will need to add in some sort of site parsing to handle differences between
    // http://www.example.com and www.example.com
    if ( !sites.contains( site ) ) {
      sites.add( site );
      return true;
    }
    return false;
  }

  public boolean removeSite( String site ) {
    if ( sites.contains( site ) ) {
      sites.remove( site );
      return true;
    }
    return false;
  }

  public void clearSiteList( ) {
    sites.clear( );
  }

  public ArrayList<String> readSites( File file ) {
    String line;
    try {
      BufferedReader in = new BufferedReader( new FileReader( file ) );
      while ( ( line = in.readLine( ) ) != null ) {
        sites.add( line );
      }
    } catch ( IOException e ) {
      System.out.println( "Could not read " + " because of the IOException " );
      e.printStackTrace( );
    }
    return sites;
  }
}
