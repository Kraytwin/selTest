package com.hardcodeshit;

import com.core.Browser;
import com.core.Screenshot;
import com.thoughtworks.selenium.DefaultSelenium;

public class BlueBadgeAdmin {

  private DefaultSelenium selenium;
  private String name, type, directory;

  public void setUp( Browser browser ) throws Exception {
    name = browser.getName( );
    type = browser.getType( );
    directory = browser.getSpecialDirectory( );
    selenium = new DefaultSelenium( browser.getServerIP( ), 4444, "*" + type + " " + browser.getFileLocation( ),
        "https://10.0.0.32/" );
    selenium.start( );
  }

  public void testNew( ) throws Exception {
    Screenshot sc = new Screenshot( "BlueBadgeAdmin", name, type, directory, selenium );

    selenium.open( "/admin/app/" );
    selenium.windowFocus( );
    selenium.chooseOkOnNextConfirmation( );
    selenium.windowMaximize( );
    sc.captureScreenshot( );
    selenium.type( "id=j_username", "user2" );
    selenium.type( "id=j_password", "Pa55w0rd" );
    selenium.click( "css=input.i-next" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View In-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[3]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[4]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[5]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[6]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[7]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[8]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "//div[@id='content']/table/tbody/tr[9]/td[6]/a" );
    selenium.waitForPageToLoad( "30000" );
    sc.captureScreenshot( );
    selenium.click( "link=View in-tray" );
    selenium.waitForPageToLoad( "30000" );
    selenium.open( "/" );
    selenium.click( "id=becsStartCalculator" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=START_QUESTION_4" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "id=CHANGE_LIST_1" );
    selenium.click( "id=CHANGE_LIST_2" );
    selenium.click( "id=CHANGE_LIST_3" );
    selenium.click( "id=CHANGE_LIST_4" );
    selenium.click( "id=CHANGE_LIST_5" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$PERSONAL_INFORMATION_PREVIOUS_ADDRESS_BADGE_LOCAL_AUTHORITY_NAME", "My LA" );
    selenium.type( "name=$$PERSONAL_INFORMATION_PREVIOUS_ADDRESS_BADGE_LOCAL_AUTHORITY_BADGE_NUMBER", "01234567" );
    selenium.select( "name=$$DD$PERSONAL_INFORMATION_PREVIOUS_ADDRESS_BADGE_LOCAL_AUTHORITY_EXPIRY_DATE", "label=1" );
    selenium.select( "name=$$MM$PERSONAL_INFORMATION_PREVIOUS_ADDRESS_BADGE_LOCAL_AUTHORITY_EXPIRY_DATE",
        "label=January" );
    selenium.type( "name=$$YY$PERSONAL_INFORMATION_PREVIOUS_ADDRESS_BADGE_LOCAL_AUTHORITY_EXPIRY_DATE", "2012" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "id=CHANGE_UPDATE_PREVIOUS_TITLE_5" );
    selenium.type( "name=$$CHANGE_UPDATE_PREVIOUS_NAME_FORENAME", "Test" );
    selenium.type( "name=$$CHANGE_UPDATE_PREVIOUS_NAME_SURNAME", "Tester" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "id=CHANGE_UPDATE_NEW_TITLE_5" );
    selenium.type( "name=$$CHANGE_UPDATE_NEW_NAME_FORENAME", "Steve" );
    selenium.type( "name=$$CHANGE_UPDATE_NEW_NAME_SURNAME", "Tester" );
    selenium.select( "name=$$DD$CHANGE_NAME_DATE", "label=1" );
    selenium.select( "name=$$MM$CHANGE_NAME_DATE", "label=January" );
    selenium.type( "name=$$YY$CHANGE_NAME_DATE", "2011" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$CHANGE_UPDATE_NEW_TITLE_OTHER", "Lord-Master" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=TNSA_INPUT_1", "CR7 8HW" );
    selenium.click( "css=input[type=\"submit\"]" );
    selenium.waitForPageToLoad( "80000" );
    selenium.select( "name=TNSA_RECORD_ID", "label=FLAT 1ST FLOOR, 81A, NORTHWOOD ROAD, THORNTON HEATH, CR7 8HW" );
    selenium.click( "css=#lookupRefineForm > div.lookup-buttons > input[type=\"submit\"]" );
    selenium.waitForPageToLoad( "80000" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=TNSA_INPUT_1", "SE25 5DD" );
    selenium.click( "css=input[type=\"submit\"]" );
    selenium.waitForPageToLoad( "80000" );
    selenium.select( "name=TNSA_RECORD_ID", "label=20 ARUN COURT, 12, HOWARD ROAD, LONDON, SE25 5DD" );
    selenium.click( "css=#lookupRefineForm > div.lookup-buttons > input[type=\"submit\"]" );
    selenium.waitForPageToLoad( "80000" );
    selenium.select( "name=$$DD$CHANGE_NEW_ADDRESS_DATE", "label=1" );
    selenium.select( "name=$$MM$CHANGE_NEW_ADDRESS_DATE", "label=January" );
    selenium.type( "name=$$YY$CHANGE_NEW_ADDRESS_DATE", "2011" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$CHANGE_BENEFIT_DETAILS", "A Change" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$CHANGE_MEDICAL_DETAILS", "New Medical Issue" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$CHANGE_OTHER_DETAILS", "Some Other Change" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.select( "name=$$DD$PERSONAL_DETAILS_BASIC_INFORMATION_DOB", "label=1" );
    selenium.select( "name=$$MM$PERSONAL_DETAILS_BASIC_INFORMATION_DOB", "label=January" );
    selenium.type( "name=$$YY$PERSONAL_DETAILS_BASIC_INFORMATION_DOB", "1986" );
    selenium.click( "id=PERSONAL_DETAILS_BASIC_INFORMATION_GENDER_1" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.type( "name=$$PERSONAL_DETAILS_PHONE_NUMBER", "0123456789" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "id=PERSONAL_DETAILS_APPLICANT_STATUS_2" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "80000" );
    // sc.captureScreenshot( );
    selenium.click( "link=Show your answers" );
    selenium.waitForPageToLoad( "80000" );
    sc.captureScreenshot( );
  }

  public void close( ) throws Exception {
    selenium.stop( );
  }
}