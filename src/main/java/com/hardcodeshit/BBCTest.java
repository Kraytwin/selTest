package com.hardcodeshit;

import java.io.IOException;

import com.core.Browser;
import com.core.Screenshot;
import com.thoughtworks.selenium.DefaultSelenium;

public class BBCTest {

  private DefaultSelenium selenium;
  private String name, type, directory;
  private boolean first;
  private Screenshot sc;

  public void setUp( Browser browser ) {
    name = browser.getName( );
    type = browser.getType( );
    directory = browser.getSpecialDirectory( );
    selenium = new DefaultSelenium( browser.getServerIP( ), 4444, "*" + type + " " + browser.getFileLocation( ),
        "http://www.bbc.co.uk/" );
    selenium.start( );
  }

  public void testNew( String site ) throws InterruptedException, IOException {
    sc = new Screenshot( "Screenshot", name, type, directory, selenium );

    selenium.open( "/news/" );
    System.out.println( selenium.isElementPresent( "link=US apology over Afghan Koran row" ) );
    selenium.click( "link=US apology over Afghan Koran row" );
    selenium.waitForPageToLoad( "30000" );
    System.out.println( selenium.isElementPresent( "link=England" ) );
    selenium.click( "link=England" );
    System.out.println( selenium.isElementPresent( "link=US apology over Afghan Koran row" ) );
    selenium.click( "link=US apology over Afghan Koran row" );
    selenium.waitForPageToLoad( "30000" );
  }

  public void close( ) throws Exception {
    selenium.stop( );
  }
}