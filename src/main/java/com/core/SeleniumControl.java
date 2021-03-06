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
    IP = browser.getServerIP( );
    directory = browser.getSpecialDirectory( );

    selenium = new DefaultSelenium( IP, 4444, "*" + type + " " + browser.getFileLocation( ), URL );
    selenium.start( );

    return selenium;
  }

  public void close( ) throws Exception {
    selenium.stop( );
  }
}
