package com.hardcodeshit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.selenium.*;
import com.core.*;

//import java.util.regex.Pattern;

public class DocGenTest {
  private DefaultSelenium selenium;
   private String name, type, directory; 
   private boolean first;
   private Screenshot sc;
    
   public void setUp( Browser browser ) {
    name = browser.getName( );
    type = browser.getType( );
    directory = browser.getScreenshotDirectory( );
      selenium = new DefaultSelenium( browser.getServerIP( ),4444,"*" + type + " " + browser.getFileLocation( ), "https://10.0.0.32/");
      selenium.start( );
    }

  public void testNew( String site ) throws InterruptedException, IOException{
    sc = new Screenshot("Screenshot", name , type, directory, selenium );
    boolean rushcliffe;
        if( site.equals( "claims_rushcliffe/" ) ) {
          rushcliffe = true;
        } else {
          rushcliffe = false;
        }
        selenium.open("/admin/");
        selenium.windowFocus( );
        selenium.windowMaximize( );
        selenium.type("id=j_username", "user2");
        selenium.type("id=j_password", "Pa55w0rd");
        try {
          selenium.click("//input[@value='Log In']");
        } catch ( SeleniumException e ) {
          selenium.click("css=input[type=submit]");
        }
        selenium.waitForPageToLoad("30000");
        this.completeIncidentReports( rushcliffe );
    
  }
  
  public void close( ) throws Exception {
    selenium.stop( );
  }
    
  private void completeIncidentReports( boolean rushcliffe ) throws InterruptedException, IOException { 
    first = true; ///*
    String age;
    boolean skipClaims=false;
    if(!skipClaims) {
      for ( int i = 10; i >= 1; i-- )  {
        selenium.click("link=View Incident Reports");
        selenium.waitForPageToLoad("30000");
        if( i == 1 ) {
          try{
            selenium.click("input[type=\"submit\"]");
          }
          catch(SeleniumException e) {
            System.out.println( "Trying alternative Incident Report link");
            selenium.click("css=#MANAGE-INCIDENT-REPORTS > input[type=\"submit\"]");
          }
        } else {
          selenium.click("//table[" + i + "]/tbody/tr[2]/td[2]/form/input[5]");
        }
        System.out.println( "Claim " + (11-i) );
      
        if(first) {
          System.out.println( "First incident report loading" );
        }
        if(i < 3) {
          age = "1930";
        } else {
          age = "1986";
        }
          selenium.waitForPageToLoad("50000");
          if( selenium.isElementPresent("id=CHILDREN_OTHER_false") ) {
		      selenium.click("id=CHILDREN_OTHER_false");
		      selenium.click("name=TNBnextButton");
		      selenium.waitForPageToLoad("30000");
          }
          if( selenium.isElementPresent( "id=PENSION_DETAILS_OCCUPATIONAL_FREQ_YOU_1" ) ) {
      		selenium.click("id=PENSION_DETAILS_OCCUPATIONAL_FREQ_YOU_1");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_AMOUNT_YOU", "50");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_COMPANY_NAME_YOU", "OccPenCorp");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_OCCUPATIONAL_FREQ_YOU_1");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_AMOUNT_YOU", "50");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_COMPANY_NAME_YOU", "OccPenCorp2");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_PRIVATE_FREQ_YOU_1");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_AMOUNT_YOU", "30");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_COMPANY_NAME_YOU", "PriPenCorp");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_AMOUNT_YOU", "50");
    		selenium.click("id=PENSION_DETAILS_PRIVATE_FREQ_YOU_1");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_COMPANY_NAME_YOU", "PriPenCorp2");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_OCCUPATIONAL_FREQ_PARTNER_1");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_AMOUNT_PARTNER", "50");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_COMPANY_NAME_PARTNER", "OccPenParCorp");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_OCCUPATIONAL_FREQ_PARTNER_1");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_AMOUNT_PARTNER", "45");
    		selenium.type("name=$$PENSION_DETAILS_OCCUPATIONAL_COMPANY_NAME_PARTNER", "OccPenParCorp2");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_PRIVATE_FREQ_PARTNER_1");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_AMOUNT_PARTNER", "32");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_COMPANY_NAME_PARTNER", "PriPenParCorp");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
    		selenium.click("id=PENSION_DETAILS_PRIVATE_FREQ_PARTNER_1");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_AMOUNT_PARTNER", "20");
    		selenium.type("name=$$PENSION_DETAILS_PRIVATE_COMPANY_NAME_PARTNER", "PriPenParCorp2");
    		selenium.click("name=TNBnextButton");
    		selenium.waitForPageToLoad("30000");
          }
        /*selenium.select("name=$$DD$DETAILS_DOB_YOU", "label=1");
        selenium.select("name=$$MM$DETAILS_DOB_YOU", "label=January");
        selenium.type("name=$$YY$DETAILS_DOB_YOU", age );
        selenium.click("name=TNBnextButton");
        selenium.waitForPageToLoad("30000");
        try {
          selenium.select("name=$$DD$DETAILS_DOB_PARTNER", "label=1");
          selenium.select("name=$$MM$DETAILS_DOB_PARTNER", "label=January");
          selenium.type("name=$$YY$DETAILS_DOB_PARTNER", age);
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
        } catch ( Exception e1 ) {
          System.out.println("Caught the partner DOB");
          //Don't need to do anything here
        }*/
        
        if(rushcliffe) {
          selenium.click("id=EXTRA_GENDER_4");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("id=EXTRA_DISABILITY_LIST_3");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("id=EXTRA_SEXUALITY_LIST_5");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("id=EXTRA_ETHNICITY_LIST_17");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("id=EXTRA_RELIGION_LIST_9");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
          selenium.click("name=TNBnextButton");
          selenium.waitForPageToLoad("30000");
        }
        selenium.click("//input[@value='Proceed']");
        selenium.waitForPageToLoad("30000");
        Runtime.getRuntime( ).exec( "sudo echo blank" );
        this.completeDeclaration( );
        System.out.println( "Submitting claim");
        Thread.sleep(12000);
        first = false;
        if( selenium.isElementPresent("link=Go to calculator home") ) {
          selenium.click("link=Go to calculator home");
          selenium.waitForPageToLoad("30000");
          selenium.click("link=Go to Admin section");
          selenium.waitForPageToLoad("30000");
        } else {
          selenium.open( "/admin/index.jsp" );
        } 
      }
      System.out.println( "Waiting for submissions to complete" );
      Thread.sleep(10000);//*/
    }
    System.out.println( "Submissions should be complete" );
    for ( int i = 10; i >= 1; i-- ) {
      selenium.click("link=Recently Submitted Claims");
      selenium.waitForPageToLoad("30000");
      selenium.click("//table[@id='recentClaimsTable']/tbody/tr[" + i + "]/td[6]/a");
      selenium.waitForPageToLoad("30000");
      String url = selenium.getLocation( );
      url = url.split( "=" )[1];
      selenium.click("link=View Claim Sheet in HTML format");
      Runtime.getRuntime( ).exec( "sudo echo blank" );
      Thread.sleep(3000);
      try {
        //selenium.selectWindow( "Online Claims - Declaration" );
        selenium.selectWindow( "Claim Sheet with Declaration - " + url );
        selenium.windowFocus( );
        System.out.println( selenium.getTitle( ) );
      } catch ( SeleniumException e ) {
        Thread.sleep(3000);
        //selenium.selectWindow( "Online Claims - Declaration" );
        selenium.selectWindow( "Claim Sheet with Declaration - " + url );
        selenium.windowFocus( );
        System.out.println( selenium.getTitle( ) );
      }
      sc.captureScreenshot( selenium.getTitle( ).replaceFirst( "Claim Sheet with Declaration - ", "" ) + "-Claim_" + (11 - i) );
      selenium.close( );
      selenium.selectWindow("null");
      selenium.windowFocus( );
      selenium.click("link=View Claim Sheet in PDF format");
      //Need to wait a second for the link to be properly clicked
      //Longer for the first claim
      if(i == 10) {
        Thread.sleep(2000);
      } else {
      Thread.sleep(200);
      }
     selenium.click("link=View Check List (PDF)");
    //Need to wait a second for the link to be properly clicked
      if(i == 10) {
        Thread.sleep(1000);
      } else {
      Thread.sleep(200);
      }
      selenium.click("id=becsGoBack");
      selenium.waitForPageToLoad("30000");
    }
    selenium.click("link=Logout");
    selenium.waitForPageToLoad("30000");
  }
  
  private void completeDeclaration( ) {
    if ( selenium.isTextPresent( "Durham" ) || selenium.isTextPresent( "durham" ) ) {
      selenium.select("name=assistanceType", "label=In person");
    }
    try{
      selenium.click("id=submit_method_print_and_send");
    }catch (SeleniumException e) {
    //Not going to do anything if this fails
    }
    try{
      selenium.click("id=agree_with_declaration");
    }catch (SeleniumException e) {
      //Not going to do anything if this fails
    }
      selenium.click("name=post_submission_options");
      selenium.waitForPageToLoad("30000");
  }
  
  
  

}
 
