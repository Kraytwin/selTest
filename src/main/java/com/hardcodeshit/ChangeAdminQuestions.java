package com.hardcodeshit;

import com.core.Browser;
import com.core.Screenshot;
import com.thoughtworks.  selenium.DefaultSelenium;

//import java.util.regex.Pattern;

public class ChangeAdminQuestions {
	private DefaultSelenium   selenium;
	 private String name, type, directory; 
	  
	 public void setUp( Browser browser ) throws Exception {
		name = browser.getName( );
		type = browser.getType( );
		directory = browser.getScreenshotDirectory( );
	      selenium = new DefaultSelenium( browser.getServerIP( ),4444,"*" + type + " " + browser.getFileLocation( ), "https://10.0.0.32/");
	      selenium.start( );
	  }

public void testNew( String site ) throws Exception {
  String siteCode;
  if( site.equals( "change_cicdemo/" ) ) {
    siteCode = "TN4";
  } else if( site.equals( "change_lbbd/" ) ) {
    siteCode = "BDC1";
  } else if( site.equals( "change_bolton/" ) ) {
    siteCode = "BOC1";
  } else if( site.equals( "change_fenland/" ) ) {
    siteCode = "FEC1";
  } else if( site.equals( "change_rochdale/" ) ) {
    siteCode = "RDC1";
  } else if( site.equals( "change_rother/" ) ) {
    siteCode = "RTC1";
  } else {
    siteCode = "TN4";
  }
    Screenshot sc = new Screenshot( siteCode, name , type, directory,   selenium );
  selenium.open("/index.jsp");  
  selenium.windowFocus( );
  selenium.chooseOkOnNextConfirmation( );
  selenium.windowMaximize( );
  if( selenium.isElementPresent( "id=j_username" ) ) {
  sc.captureScreenshot( "Authenticate" );
    selenium.type("id=j_username", "user2");
    selenium.type("id=j_password", "Wrong");
    selenium.click("css=input[type=\"submit\"]");
    selenium.waitForPageToLoad("30000");
  sc.captureScreenshot( "LoginError" );
    selenium.type("id=j_username", "user2");
    selenium.type("id=j_password", "Pa55w0rd");
    selenium.click("css=input[type=\"submit\"]");
    selenium.waitForPageToLoad("30000");
  }
sc.captureScreenshot("IndexPage");
  if( selenium.isElementPresent( "id=becsStartCalculator" ) ) {
    selenium.click("id=becsStartCalculator");
  } else {
	selenium.click("link=REPORT");
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("Intro");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("QuestionStart");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("QuestionStartError");
  selenium.click("id=AUTHENTICATION_TITLE_1");
  selenium.type("name=$$AUTHENTICATION_FIRST_NAME", "TNS");
  selenium.type("name=$$AUTHENTICATION_LAST_NAME", "Test");
  selenium.select("name=$$DD$AUTHENTICATION_DOB", "label=1");
  selenium.select("name=$$MM$AUTHENTICATION_DOB", "label=January");
  selenium.type("name=$$YY$AUTHENTICATION_DOB", "1990");
  selenium.click("id=AUTHENTICATION_NI_KNOWN_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.type("id=TNSA_V", "Pa55w0rd");
  selenium.type("id=TNSA_CON", "Pa55w0rd");
  selenium.click("id=becsSaveSession");
  selenium.waitForPageToLoad("30000");
  sc.captureScreenshot("SaveSession");

//Now just logging out so the session 000-001 is invalidated.
  selenium.open( "logout.jsp" );
sc.captureScreenshot( "Logout" );
  selenium.open("/index.jsp");  
  if( selenium.isElementPresent( "id=j_username" ) ) {
    selenium.type("id=j_username", "user2");
    selenium.type("id=j_password", "Pa55w0rd");
    selenium.click("css=input[type=\"submit\"]");
    selenium.waitForPageToLoad("30000");
  }
//Now to return to the beginning and resume the session
  selenium.open( "/index.jsp" );
  if ( selenium.isElementPresent( "link=click here" ) ) {
  selenium.click("link=click here");
  } else {
    selenium.click("link=RETURN");
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "ReturningIndex" );
  selenium.type("id=REFERENCE", siteCode + "-000-XXX");
  selenium.type("id=PASSWORD", "Wrong");
  if( selenium.isElementPresent( "//input[@value='Start']" ) ) {
    selenium.click( "//input[@value='Start']" );
  } else {
  selenium.click("css=input[type=\"submit\"]");
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "ReturningIndexError" );
  selenium.type("id=REFERENCE", siteCode + "-000-001");
  selenium.type("id=PASSWORD", "Pa55w0rd");
  if( selenium.isElementPresent( "//input[@value='Start']" ) ) {
    selenium.click( "//input[@value='Start']" );
  } else {
  selenium.click("css=input[type=\"submit\"]");
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "ReturningIndexSession" );
//Now to create a new claim
  selenium.open( "index.jsp" );
  if( selenium.isElementPresent( "id=becsStartCalculator" ) ) {
	    selenium.click("id=becsStartCalculator");
	  } else {
		selenium.click("link=REPORT");
	  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("Intro");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("QuestionStart");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("QuestionStartError");
  selenium.click("id=AUTHENTICATION_TITLE_1");
  selenium.type("name=$$AUTHENTICATION_FIRST_NAME", "TNS");
  selenium.type("name=$$AUTHENTICATION_LAST_NAME", "Test");
  selenium.select("name=$$DD$AUTHENTICATION_DOB", "label=1");
  selenium.select("name=$$MM$AUTHENTICATION_DOB", "label=January");
  selenium.type("name=$$YY$AUTHENTICATION_DOB", "1990");
  selenium.click("id=AUTHENTICATION_NI_KNOWN_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  if( selenium.isTextPresent( "property address" ) ) {
  selenium.click("css=div.lookup-buttons > input[type=\"submit\"]");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("PropertyLookup");
  }
  selenium.type("name=$$AUTHENTICATION_ADDRESS_FLAT", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_HOUSE", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_STREET", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_TOWN", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_POSTCODE", "A1 1AA");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_START_BOOLEAN_true");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_ADDRESS_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_ADDRESS_KIND_OF_HOME_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("KindOfHome");
  selenium.click("id=PROPERTY_ADDRESS_KIND_OF_HOME_4");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_RENT_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_COUNCIL_TAX_BAND_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_LANDLORD_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_PRIVATE_RENTING_DETAILS_true");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_CENTRAL_HEATING_false");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_GARDEN_false");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_GARAGE_false");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_PARKING_false");
  selenium.select("name=$$DD$PROPERTY_RENTING_FACILITIES_DATE", "label=1");
  selenium.select("name=$$MM$PROPERTY_RENTING_FACILITIES_DATE", "label=January");
  selenium.type("name=$$YY$PROPERTY_RENTING_FACILITIES_DATE", "2009");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("NumberOfRooms");
  selenium.type("name=$$PROPERTY_RENTING_LIVING_ROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_SITTING_ROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_BEDROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_BATHROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_TOILETS", "1");
  selenium.type("name=$$PROPERTY_RENTING_KITCHENS", "1");
  selenium.type("name=$$PROPERTY_RENTING_OTHER_ROOMS", "1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("TenancyType");
  selenium.click("id=PROPERTY_RENTING_TENANCY_1");
  selenium.click("id=PROPERTY_RENTING_TENANCY_TYPE_1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("PropertyOverview");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PAYMENT_START_BOOLEAN_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_START_BOOLEAN_true");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_PERSONAL_DETAILS_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_UNEARNED_INCOME_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_SAVINGS_CHANGE_true");
    selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("SavingTypes");
  selenium.click("id=CLAIMANT_SAVINGS_ACCOUNTS_ADD_LIST_10");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Help" );
  selenium.click("name=_*CLAIMANT_SAVINGS_DISREGARDED");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "HelpSelected" );
  selenium.click("id=CLAIMANT_SAVINGS_DISREGARDED_8");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.type("name=$$CLAIMANT_SAVINGS_ACCOUNT_OTHER_NUMBER", "10");
  selenium.select("name=$$DD$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "label=1");
  selenium.select("name=$$MM$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "label=January");
  selenium.type("name=$$YY$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "2009");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_SAVINGS_EXTRA_MONEY_ADD_MORE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_EXPENSES_STUDENT_CHANGE_3");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_OWED_MONEY_CHANGE_4");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_EARNED_INCOME_CHANGE_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("ClaimantOverview");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PARTNER_START_BOOLEAN_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PEOPLE_START_BOOLEAN_false");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=Show your answers");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("ShowYourAnswers");
  if(selenium.isElementPresent("link=Report an Incident")) {
	selenium.click("link=Report an Incident");
  	selenium.waitForPageToLoad("30000");
  sc.captureScreenshot("IncidentReport");
  	selenium.type("name=TNSA_INCIDENT_REPORT_DESCRIPTION", "TestIncidentReport.");
  	selenium.click("id=becsSubmitIncident");
  	selenium.waitForPageToLoad("30000");
  }
  selenium.click("id=SUPP_MAKING_THE_CHANGE_1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  if(selenium.isElementPresent("id=CLAIMANT_ETHNICITY_17")) {
	selenium.click("id=CLAIMANT_ETHNICITY_17");
	selenium.click("name=TNBnextButton");
	selenium.waitForPageToLoad("30000");
  }
sc.captureScreenshot("1of3");
  selenium.click("//input[@value='Proceed']");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("2of3_submit");
  if(selenium.isElementPresent("id=submit_method_print_and_send")) {
    selenium.click("id=submit_method_print_and_send");
  } else {
	selenium.click("id=agree_with_declaration");
  }
  selenium.click("name=post_submission_options");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("3of3Submitted_SS");
  if( selenium.isElementPresent("link=Go to calculator home") ) {
    selenium.click("link=Go to calculator home");
    selenium.waitForPageToLoad("30000");
  } else {
	  selenium.open( "/index.jsp" );
  }
  if ( selenium.isElementPresent("link=Your Privacy") ) {
    selenium.click("link=Your Privacy");
    selenium.waitForPageToLoad("30000");
  } else {
    selenium.open( "your_privacy.jsp" );
  }
sc.captureScreenshot("YourPrivacy");
if( !  selenium.isElementPresent( "link=back to previous page" ) ) {
    selenium.open( "/index.jsp" );
} else {
    selenium.click("link=back to previous page");
    selenium.waitForPageToLoad("30000");
}
  if( selenium.isElementPresent("link=exact:Stuck? Get help") ) {
    selenium.click("link=exact:Stuck? Get help");
  } else {
    selenium.open( "/stuck.jsp" );
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("Stuck");
  selenium.open("/advisor.jsp");
sc.captureScreenshot( "Advisor" );
  selenium.open("/claimPreviouslySubmitted.jsp");
sc.captureScreenshot( "PreviouslySubmitted" );
  selenium.open("/disclaimer.jsp");
sc.captureScreenshot( "Disclaimer" );
  selenium.open("/error.jsp");
sc.captureScreenshot( "Error" );
  selenium.open("/forbidden.jsp");
sc.captureScreenshot( "Forbidden" );
  selenium.open("/helpful_tips.jsp");
sc.captureScreenshot( "HelpfulTips" );
  selenium.open("/laptop_index.jsp");
sc.captureScreenshot( "LaptopIndex" );
  selenium.open("/login.jsp");
sc.captureScreenshot( "Login" );
  selenium.open("/reportNullNode.jsp");
sc.captureScreenshot( "ReportNullNode" );
  selenium.open( "/index.jsp" );
  selenium.waitForPageToLoad("30000");


  Runtime.getRuntime( ).exec( "sudo echo blank" );
  selenium.click("link=Switch to accessible version");
  selenium.waitForPageToLoad("30000");
//Resuming a session
  if(selenium.isElementPresent("link=click here")) {
	  selenium.click("link=click here");
  } else {
	  selenium.click("link=RETURN");
  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Access_ReturningIndex" );
  selenium.type("id=REFERENCE", siteCode + "-000-001");
  selenium.type("id=PASSWORD", "Wrong");
  selenium.click("css=input[type=\"submit\"]");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Access_ReturningIndexError" );
  selenium.type("id=REFERENCE", siteCode + "-000-001");
  selenium.type("id=PASSWORD", "Pa55w0rd");
  selenium.click("css=input[type=\"submit\"]");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Access_ReturningIndexSession" );
  selenium.open( "/index.jsp" );
//Now to create a new claim
  if(selenium.isElementPresent("link=Switch to accessible version") ) {
    selenium.click("link=Switch to accessible version");
    selenium.waitForPageToLoad("30000");
  }
  if( selenium.isElementPresent( "id=becsStartCalculator" ) ) {
	    selenium.click("id=becsStartCalculator");
	  } else {
		selenium.click("link=REPORT");
	  }
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessIntro");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessQuestionStart");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessQuestionStartError");
  selenium.click("id=AUTHENTICATION_TITLE_1");
  selenium.type("name=$$AUTHENTICATION_FIRST_NAME", "TNS");
  selenium.type("name=$$AUTHENTICATION_LAST_NAME", "Test");
  selenium.select("name=$$DD$AUTHENTICATION_DOB", "label=1");
  selenium.select("name=$$MM$AUTHENTICATION_DOB", "label=January");
  selenium.type("name=$$YY$AUTHENTICATION_DOB", "1990");
  selenium.click("id=AUTHENTICATION_NI_KNOWN_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  if( selenium.isTextPresent( "property address" ) ) {
	  selenium.click("css=div.lookup-buttons > input[type=\"submit\"]");
	  selenium.waitForPageToLoad("30000");
	sc.captureScreenshot("AccessPropertyLookup");
  }
  selenium.type("name=$$AUTHENTICATION_ADDRESS_FLAT", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_HOUSE", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_STREET", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_TOWN", "a");
  selenium.type("name=$$AUTHENTICATION_ADDRESS_POSTCODE", "A1 1AA");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_START_BOOLEAN_TRUE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_ADDRESS_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_ADDRESS_KIND_OF_HOME_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessKindOfHome");
  selenium.click("id=PROPERTY_ADDRESS_KIND_OF_HOME_4");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_RENT_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_COUNCIL_TAX_BAND_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_LANDLORD_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_PRIVATE_RENTING_DETAILS_TRUE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_CENTRAL_HEATING_FALSE");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_GARDEN_FALSE");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_GARAGE_FALSE");
  selenium.click("id=PROPERTY_RENTING_FACILITIES_PARKING_FALSE");
  selenium.select("name=$$DD$PROPERTY_RENTING_FACILITIES_DATE", "label=1");
  selenium.select("name=$$MM$PROPERTY_RENTING_FACILITIES_DATE", "label=January");
  selenium.type("name=$$YY$PROPERTY_RENTING_FACILITIES_DATE", "2009");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessNumberOfRooms");
  selenium.type("name=$$PROPERTY_RENTING_LIVING_ROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_SITTING_ROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_BEDROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_BATHROOMS", "1");
  selenium.type("name=$$PROPERTY_RENTING_TOILETS", "1");
  selenium.type("name=$$PROPERTY_RENTING_KITCHENS", "1");
  selenium.type("name=$$PROPERTY_RENTING_OTHER_ROOMS", "1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessTenancyType");
  selenium.click("id=PROPERTY_RENTING_TENANCY_1");
  selenium.click("id=PROPERTY_RENTING_TENANCY_TYPE_1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessPropertyOverview");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PAYMENT_START_BOOLEAN_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_START_BOOLEAN_TRUE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_PERSONAL_DETAILS_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_UNEARNED_INCOME_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_SAVINGS_CHANGE_TRUE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessSavingTypes");
  selenium.click("id=CLAIMANT_SAVINGS_ACCOUNTS_ADD_LIST_10");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "AccessHelp" );
  selenium.click("name=_*CLAIMANT_SAVINGS_DISREGARDED");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "AccessHelpSelected" );
  selenium.click("id=CLAIMANT_SAVINGS_DISREGARDED_8");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.type("name=$$CLAIMANT_SAVINGS_ACCOUNT_OTHER_NUMBER", "10");
  selenium.select("name=$$DD$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "label=1");
  selenium.select("name=$$MM$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "label=January");
  selenium.type("name=$$YY$CLAIMANT_SAVINGS_ACCOUNT_OTHER_DATE", "2009");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_SAVINGS_EXTRA_MONEY_ADD_MORE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_EXPENSES_STUDENT_CHANGE_3");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_OWED_MONEY_CHANGE_4");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=CLAIMANT_EARNED_INCOME_CHANGE_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessClaimantOverview");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PARTNER_START_BOOLEAN_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=PEOPLE_START_BOOLEAN_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=Show Your Answers");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessShowYourAnswers");
  if( selenium.isElementPresent("name=TNSA_INCIDENT_REPORT_DESCRIPTION") ) {
    selenium.type("name=TNSA_INCIDENT_REPORT_DESCRIPTION", "TestIncidentReport.");
    selenium.click("css=input.incidentReport");
    selenium.waitForPageToLoad("30000");
  }
  selenium.type("id=TNSA_V", "Pa55w0rd");
  selenium.type("id=TNSA_CON", "Pa55w0rd");
  selenium.click("//input[@value='Save']");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("AccessSaveSession");
  if( selenium.isElementPresent("id=PEOPLE_START_BOOLEAN_FALSE") ) {
	  selenium.click("id=PEOPLE_START_BOOLEAN_FALSE");
	  selenium.click("name=TNBnextButton");
	  selenium.waitForPageToLoad("30000");
  }
  selenium.click("id=SUPP_MAKING_THE_CHANGE_1");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  if(selenium.isElementPresent("id=CLAIMANT_ETHNICITY_17")) {
		selenium.click("id=CLAIMANT_ETHNICITY_17");
		selenium.click("name=TNBnextButton");
		selenium.waitForPageToLoad("30000");
	  }
sc.captureScreenshot("Access1of3");
  selenium.click("css=form[title=\"Submit\"] > input[type=\"submit\"]");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("Access2of3");
  if(selenium.isElementPresent("id=submit_method_print_and_send")) {
    selenium.click("id=submit_method_print_and_send");
  } else {
	selenium.click("id=agree_with_declaration");
  }
  selenium.click("name=post_submission_options");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot("Access3of3Submitted");
  selenium.open( "/your_privacy.jsp" );
sc.captureScreenshot("Access_YourPrivacy");
  selenium.open( "/stuck.jsp" );
sc.captureScreenshot("Access_Stuck");
  selenium.open("/advisor.jsp");
sc.captureScreenshot( "Access_Advisor" );
  selenium.open("/claimPreviouslySubmitted.jsp");
sc.captureScreenshot( "Access_PreviouslySubmitted" );
  selenium.open("/disclaimer.jsp");
sc.captureScreenshot( "Access_Disclaimer" );
  selenium.open("/error.jsp");
sc.captureScreenshot( "Access_Error" );
  selenium.open("/forbidden.jsp");
sc.captureScreenshot( "Access_Forbidden" );
  selenium.open("/helpful_tips.jsp");
sc.captureScreenshot( "Access_HelpfulTips" );
  selenium.open("/laptop_index.jsp");
sc.captureScreenshot( "Access_LaptopIndex" );
  selenium.open("/login.jsp");
sc.captureScreenshot( "Access_Login" );
  selenium.open("/reportNullNode.jsp");
sc.captureScreenshot( "Access_ReportNullNode" );
if( !  selenium.isElementPresent( "link=back to previous page" ) ) {
    selenium.open( "/index.jsp" );
} else {
  selenium.click("link=back to previous page");
  selenium.waitForPageToLoad("30000");
}


//Now to create a claim for admin/resumeSession.jsp to use
if( selenium.isElementPresent( "id=becsStartCalculator" ) ) {
    selenium.click("id=becsStartCalculator");
  } else {
	selenium.click("link=REPORT");
  }
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("id=AUTHENTICATION_TITLE_1");
  selenium.type("name=$$AUTHENTICATION_FIRST_NAME", "TNS");
  selenium.type("name=$$AUTHENTICATION_LAST_NAME", "Test");
  selenium.select("name=$$DD$AUTHENTICATION_DOB", "label=1");
  selenium.select("name=$$MM$AUTHENTICATION_DOB", "label=January");
  selenium.type("name=$$YY$AUTHENTICATION_DOB", "1990");
  selenium.click("id=AUTHENTICATION_NI_KNOWN_FALSE");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.click("name=TNBnextButton");
  selenium.waitForPageToLoad("30000");
  selenium.open( "logout.jsp" );
  selenium.waitForPageToLoad("30000");



  Runtime.getRuntime( ).exec( "sudo echo blank" );

  selenium.open("/admin/home");
sc.captureScreenshot( "Admin_Login" );
  selenium.type("j_username", "user2");
  selenium.type("j_password", "Pa55w0rd");
  selenium.click("//input[@value='Login']");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_Home" );
if( !  selenium.isElementPresent( "link=Find Claimant" ) ) {
  System.out.println( "Find Claimant not found" );
} else {
    selenium.click("link=Find Claimant");
    selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ReportChanges" );
//    selenium.click("//ul[@id='tabs']/li/a/span");
//    selenium.waitForPageToLoad("30000");
//sc.captureScreenshot( );
    selenium.click("//div[@id='content']/div/div[1]/ul/li[2]/a/span");
    selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_PersonSearch" );
    selenium.select("titleChoice", "label=Mr");
    selenium.type("surnameField", "Smith");
    selenium.click("//input[@value='Search']");
    selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_PersonSearchResults" );
    selenium.click("//img[@alt='BECS Change Administration Panel']");
    selenium.waitForPageToLoad("30000");
}
  selenium.click("link=View Submissions");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewSubmissions" );
if ( !  selenium.isElementPresent( "link=View" ) ) {
  System.out.println("View Submission Details not found");
} else {
    selenium.click( "link=View" );
    selenium.waitForPageToLoad( "30000" );
sc.captureScreenshot( "Admin_ViewSubmissionDetails" );
}
  selenium.click("//ul[@id='tabs']/li[2]/a/span");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_SearchSubmissionsByDate" );
  selenium.type("//input[@name='startDateField:date']", "15/08/11");
  selenium.type("//input[@name='endDateField:date']", "28/02/12");
  selenium.click("//input[@value='Search']");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_SearchSubmissionResults" );
//  selenium.open("https://10.0.0.32/admin/submissionSearch.10.1");
//  selenium.click("//a[@id='id21']/span");
  selenium.click("//li[@class='tab1']/a/span");
sc.captureScreenshot( "Admin_SearchSubmissionsBySession" );
  //  selenium.open("https://10.0.0.32/admin/submissionSearch.18.1");
//  selenium.click("//a[@id='id23']/span");
  selenium.click("//li[@class='tab2 last']/a/span");
sc.captureScreenshot( "Admin_SearchSubmissionsByDetails" );
  selenium.click("//img[@alt='BECS Change Administration Panel']");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=View Users");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewUsers" );
  selenium.click("link=View");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewUserDetails" );
  selenium.click("//div[@id='content']/div/div[1]/ul/li[2]/a/span");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewUserPassword" );
  selenium.click("//ul[@id='tabs']/li[2]/a/span");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_CreateUser" );
  selenium.click("//ul[@id='tabs']/li[3]/a/span");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_UpdateUser" );
  selenium.click("//img[@alt='BECS Change Administration Panel']");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=View Sessions");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewSessions" );
  selenium.click("link=Resume");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ResumeSession" );
  selenium.open( "/admin/home" );
  selenium.click("link=View Statistics");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewStatistics" );
  selenium.type("name=startDateField:date", "21/02/12");
  selenium.type("name=endDateField:date", "28/02/12");
  selenium.click("//input[@value='Update']");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewStatsisticsSearch" );
  selenium.click("home");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=View Organisations");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewOrganistations" );
  selenium.click("link=Create Organisation");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_CreateOrganisations" );
  selenium.click("//a[@id='home']/img");
  selenium.waitForPageToLoad("30000");
  selenium.click("link=View Reports");
  selenium.waitForPageToLoad("30000");
sc.captureScreenshot( "Admin_ViewReports" );
  selenium.click("//a[@id='home']/img");
  selenium.waitForPageToLoad("30000");
if ( !  selenium.isElementPresent( "link=Document Transfer" ) ) {
  System.out.println("Document Trandfer not found");
} else {
    selenium.click( "link=Document Transfer" );
    selenium.waitForPageToLoad( "30000" );
  sc.captureScreenshot( "Admin_DocumentTransfer" );
    selenium.click( "link=Edit" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "css=#home > img" );
    selenium.waitForPageToLoad( "30000" );
}
if ( !  selenium.isElementPresent( "link=Data Transfer" ) ) {
  System.out.println( "Data Transfer not found" );
} else {
  sc.captureScreenshot( "Admin_DocumentTransferClaim" );
    selenium.click( "link=Data Transfer" );
    selenium.waitForPageToLoad( "30000" );
  sc.captureScreenshot( "Admin_DataTransfer" );
}
  selenium.click("css=#logout > img");
  selenium.waitForPageToLoad("30000");
}






public void close() throws Exception {
      selenium.stop();
  }
}