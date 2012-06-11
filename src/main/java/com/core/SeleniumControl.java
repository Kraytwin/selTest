package com.core;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumControl {

  private DefaultSelenium selenium;
  private String name, type, directory, IP;

  public SeleniumControl( ) {

  }

  public DefaultSelenium setUp( Browser browser, String URL ) throws Exception {
    name = browser.getName( );
    type = browser.getType( );
    if ( browser.hasAlternativeIP( ) ) {
      IP = browser.getServerIP( );
    } else {
      // XXX Get default IP
    }
    if ( browser.hasAlternativeDirectory( ) ) {
      directory = browser.getSpecialDirectory( );
    } else {
      // XXX Get Default Directory
    }

    selenium = new DefaultSelenium( IP, 4444, "*" + type + " " + browser.getFileLocation( ), URL );
    selenium.start( );

    return selenium;
  }

  public void close( ) throws Exception {
    selenium.stop( );
  }
}
