package com.core;

import java.util.ArrayList;

import org.apache.log4j.*;

import com.thoughtworks.selenium.DefaultSelenium;

public class NavigationUnitControl {

  private ArrayList<NavigationUnit> navUnits;
  private String custMethodPrefix, url, currentNavUnit;
  private DefaultSelenium sel;
  private SeleniumControl sc;

  static Logger log = Logger.getLogger( "LogTest" );

  public NavigationUnitControl( String urlIn ) {
    this( );
    // This will be overwritten if there is a URL in the XML
    this.url = urlIn;
  }

  public NavigationUnitControl( ) {
    navUnits = new ArrayList<NavigationUnit>( );

  }

  public void runNavSequence( Browser browser ) {
    ArrayList<SeleniumMethod> methods;
    sc = new SeleniumControl( );
    try {

      sel = sc.setUp( browser, url );

      // XXX Need to take care of all system messages
      for ( NavigationUnit navUnit : navUnits ) {
        currentNavUnit = navUnit.getName( );
        methods = navUnit.getMethods( );
        this.runMethods( methods );
        // Now need to deal with special methods.
      }

      sc.close( );
    } catch ( Exception e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    }

  }

  public void setCustomMethodPrefix( String customMethodPrefixIn ) {
    this.custMethodPrefix = customMethodPrefixIn;
  }

  public String getCustomMethodPrefix( ) {
    return custMethodPrefix;
  }

  public void setURL( String urlIn ) {
    url = urlIn;
  }

  // XXX Need to handle selenium Exceptions
  /**
   * returns true if it made it all the way through.
   */
  private boolean runMethods( ArrayList<SeleniumMethod> methods ) {
    SeleniumMethodControl mc = new SeleniumMethodControl( currentNavUnit );
    boolean status;
    int i = 0;
    for ( SeleniumMethod m : methods ) {
      mc.setNewMethod( m );
      status = mc.runMethod( i );
      i++;
    }

    return true;
  }

}
