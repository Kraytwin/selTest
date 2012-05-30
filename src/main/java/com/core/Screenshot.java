package com.core;

import java.io.IOException;

import com.thoughtworks.selenium.DefaultSelenium;


public class Screenshot {

  private String browser, browserName, siteName, directory;
  private DefaultSelenium selenium;
  private int i;
  //Addition of Selenium being added is only temporary as an instance of selenium will be used
  public Screenshot( String site, String browserUsed, String browserType, String screenshotLocation, DefaultSelenium sel ) {
    browser = browserType;
    browserName = browserUsed;
    siteName = site;
    directory = screenshotLocation;
    i = 0;
    selenium = sel;
    
  }
  
  public void captureScreenshot( String page ) {
    try {
    	if ( !page.equals( Integer.toString( i ) ) ) {
    		page = page + "_" + i;
    	}
      if ( browser.equals( "iexploreproxy" ) || browser.equals( "chrome" ) ) {
    	Thread.sleep(500);
        //selenium.captureEntirePageScreenshot( directory + browserName + "_" + siteName + "_" + page + ".png", "");
        selenium.captureEntirePageScreenshot( directory + siteName + "_" + page + ".png", "");
        //System.out.println("Taking fullscreen screenshot in " + browserName + "_" + siteName + "_" + page);
        System.out.println("Taking fullscreen screenshot in " + siteName + "_" + page);
        Thread.sleep(500);
      } else {
        //Only takes a photo of the main monitor
    	Thread.sleep(500);
        Runtime.getRuntime( ).exec( "screencapture " + directory + browserName + "_" + siteName + "_" + page + ".png"  );
        System.out.println("Taking screenshot in " + browserName + "_" + siteName + "_" + page);
        Thread.sleep(500);
      }
      i++;
    }catch (IOException e) {
      e.printStackTrace( );
    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void captureScreenshot( ) {
	  this.captureScreenshot( Integer.toString( i ) );
  }
  
}
