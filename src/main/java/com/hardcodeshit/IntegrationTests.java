package com.hardcodeshit;

import com.thoughtworks.selenium.*;
import com.core.*;

//import java.util.regex.Pattern;

public class IntegrationTests {

  private DefaultSelenium selenium;
  private String name, type, directory;

  public void setUp( Browser browser ) throws Exception {
    name = browser.getName( );
    type = browser.getType( );
    directory = browser.getScreenshotDirectory( );
    selenium = new DefaultSelenium( browser.getServerIP( ), 4444, "*" + type + " " + browser.getFileLocation( ),
        "https://rochdalechangetest.teamnetsol.com/" );
    selenium.start( );
  }

  public void testNew( ) throws Exception {
    Screenshot sc = new Screenshot( "Change", name, type, directory, selenium );

    selenium.open( "/index.jsp" );
    selenium.windowFocus( );
    selenium.chooseOkOnNextConfirmation( );
    selenium.windowMaximize( );
    selenium.type( "j_username", "rochdalechangetest" );
    selenium.type( "j_password", "j4k3Teamnetsol!" );
    selenium.click( "//input[@value='Log In']" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "link=REPORT" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "AUTHENTICATION_TITLE_1" );
    selenium.type( "$$AUTHENTICATION_FIRST_NAME", "Test" );
    selenium.type( "$$AUTHENTICATION_LAST_NAME", "Claim 1" );
    selenium.type( "$$YY$AUTHENTICATION_DOB", "1986" );
    selenium.select( "$$DD$AUTHENTICATION_DOB", "label=1" );
    selenium.select( "$$MM$AUTHENTICATION_DOB", "label=June" );
    selenium.click( "AUTHENTICATION_NI_KNOWN_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$AUTHENTICATION_NI", "AB123456D" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$AUTHENTICATION_EMAIL_CONFIRM", "test@nowhere.com" );
    selenium.type( "$$AUTHENTICATION_EMAIL", "test@nowhere.com" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$AUTHENTICATION_ADDRESS_FLAT", "1" );
    selenium.type( "$$AUTHENTICATION_ADDRESS_HOUSE", "5" );
    selenium.type( "$$AUTHENTICATION_ADDRESS_STREET", "TNS CLAIM STREET" );
    selenium.type( "$$AUTHENTICATION_ADDRESS_TOWN", "TNS CLAIM TOWN" );
    selenium.type( "$$AUTHENTICATION_ADDRESS_POSTCODE", "TN53LA" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_START_BOOLEAN_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_ADDRESS_CHANGE_false" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_ADDRESS_KIND_OF_HOME_CHANGE_false" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_ADDRESS_KIND_OF_HOME_4" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_RENT_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_RENT_HOW_OFTEN_2" );
    selenium.type( "$$PROPERTY_RENT_AMOUNT", "500" );
    selenium.select( "$$DD$PROPERTY_RENT_AMOUNT_DATE", "label=1" );
    selenium.select( "$$MM$PROPERTY_RENT_AMOUNT_DATE", "label=January" );
    selenium.type( "$$YY$PROPERTY_RENT_AMOUNT_DATE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_RENT_FREE_WEEKS_false" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_COUNCIL_TAX_BAND_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_COUNCIL_TAX_WHO_1" );
    selenium.select( "$$DD$PROPERTY_COUNCIL_TAX_WHO_DATE", "label=1" );
    selenium.select( "$$MM$PROPERTY_COUNCIL_TAX_WHO_DATE", "label=January" );
    selenium.type( "$$YY$PROPERTY_COUNCIL_TAX_WHO_DATE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_COUNCIL_TAX_BAND_DISABLED_REDUCTION_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_COUNCIL_TAX_BAND_3" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_LANDLORD_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$PROPERTY_LANDLORD_NAME", "Landlord" );
    selenium.type( "$$PROPERTY_LANDLORD_FLAT", "1" );
    selenium.type( "$$PROPERTY_LANDLORD_HOUSE", "Nowhere" );
    selenium.type( "$$PROPERTY_LANDLORD_STREET", "Nowhere Street" );
    selenium.type( "$$PROPERTY_LANDLORD_TOWN", "Nowhereville" );
    selenium.type( "$$PROPERTY_LANDLORD_POSTCODE", "A1 1AA" );
    selenium.select( "$$DD$PROPERTY_LANDLORD_DATE", "label=1" );
    selenium.select( "$$MM$PROPERTY_LANDLORD_DATE", "label=January" );
    selenium.type( "$$YY$PROPERTY_LANDLORD_DATE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_LANDLORD_RELATED_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$PROPERTY_LANDLORD_RELATED_WHO", "Tester Landlord" );
    selenium.click( "PROPERTY_LANDLORD_RELATED_HOW_1" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PROPERTY_LANDLORD_AGENT_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_DETAILS_NAME", "Landlord Agent" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_FLAT", "1" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_HOUSE", "Somewhere" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_STREET", "Somewhere Street" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_TOWN", "Somewhereville" );
    selenium.type( "$$PROPERTY_LANDLORD_AGENT_POSTCODE", "B2 2BB" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=PROPERTY_PRIVATE_RENTING_DETAILS_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=PROPERTY_RENTING_FACILITIES_CENTRAL_HEATING_true" );
    selenium.click( "id=PROPERTY_RENTING_FACILITIES_GARDEN_true" );
    selenium.click( "id=PROPERTY_RENTING_FACILITIES_GARAGE_true" );
    selenium.click( "id=PROPERTY_RENTING_FACILITIES_PARKING_true" );
    selenium.select( "name=$$DD$PROPERTY_RENTING_FACILITIES_DATE", "label=1" );
    selenium.select( "name=$$MM$PROPERTY_RENTING_FACILITIES_DATE", "label=January" );
    selenium.type( "name=$$YY$PROPERTY_RENTING_FACILITIES_DATE", "2011" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "name=$$PROPERTY_RENTING_LIVING_ROOMS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_SITTING_ROOMS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_BEDROOMS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_BATHROOMS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_TOILETS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_KITCHENS", "3" );
    selenium.type( "name=$$PROPERTY_RENTING_OTHER_ROOMS", "12" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=PROPERTY_RENTING_TENANCY_1" );
    selenium.click( "id=PROPERTY_RENTING_TENANCY_TYPE_4" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );

    selenium.click( "PAYMENT_START_BOOLEAN_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PAYMENT_WHO_CHANGE_BOOLEAN_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "PAYMENT_WHO_LIST_3" );
    selenium.select( "$$DD$PAYMENT_WHO_DATE", "label=14" );
    selenium.select( "$$MM$PAYMENT_WHO_DATE", "label=January" );
    selenium.type( "$$YY$PAYMENT_WHO_DATE", "2008" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "name=$$PAYMENT_ACCOUNT_NAME", "Claim 1 Banking" );
    selenium.type( "name=$$PAYMENT_ACCOUNT_BANK_NAME", "Bank1" );
    selenium.type( "name=$$PAYMENT_ACCOUNT_NUMBER", "01234567" );
    selenium.type( "name=$$PAYMENT_ACCOUNT_SORT_CODE", "012345" );
    selenium.click( "id=PAYMENT_ACCOUNT_TYPE_LIST_1" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=PAYMENT_REASON_FOR_NOT_PAYMENT_TO_CLAIMANT_LIST_1" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );

    selenium.click( "CLAIMANT_START_BOOLEAN_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_PERSONAL_DETAILS_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_NAME_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$CLAIMANT_FIRST_NAME", "TESTING" );
    selenium.type( "$$CLAIMANT_LAST_NAME", "TESTERING" );
    selenium.click( "CLAIMANT_TITLE_5" );
    selenium.select( "$$DD$CLAIMANT_NAME_DATE_OF_CHANGE", "label=14" );
    selenium.select( "$$MM$CLAIMANT_NAME_DATE_OF_CHANGE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_NAME_DATE_OF_CHANGE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$CLAIMANT_TITLE_OTHER", "Lord Master" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_OTHER_NAMES_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$CLAIMANT_OTHER_NAME", "Testy" );
    selenium.select( "$$DD$CLAIMANT_OTHER_NAME_DATE_OF_CHANGE", "label=1" );
    selenium.select( "$$MM$CLAIMANT_OTHER_NAME_DATE_OF_CHANGE", "label=February" );
    selenium.type( "$$YY$CLAIMANT_OTHER_NAME_DATE_OF_CHANGE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_NATIONAL_INSURANCE_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$CLAIMANT_NATIONAL_INSURANCE_NUMBER", "AA654321A" );
    selenium.select( "$$DD$CLAIMANT_NATIONAL_INSURANCE_NUMBER_DATE", "label=1" );
    selenium.select( "$$MM$CLAIMANT_NATIONAL_INSURANCE_NUMBER_DATE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_NATIONAL_INSURANCE_NUMBER_DATE", "2010" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_PHONE_NUMBER_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "$$CLAIMANT_PHONE_NUMBER", "0161 000 000" );
    selenium.click( "CLAIMANT_PHONE_NUMBER_TYPE_1" );
    selenium.select( "$$DD$CLAIMANT_PHONE_NUMBER_DATE_OF_CHANGE", "label=12" );
    selenium.select( "$$MM$CLAIMANT_PHONE_NUMBER_DATE_OF_CHANGE", "label=February" );
    selenium.type( "$$YY$CLAIMANT_PHONE_NUMBER_DATE_OF_CHANGE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_NATIONALITY_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_NATIONALITY_2" );
    selenium.select( "$$DD$CLAIMANT_NATIONALITY_DATE_OF_CHANGE", "label=19" );
    selenium.select( "$$MM$CLAIMANT_NATIONALITY_DATE_OF_CHANGE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_NATIONALITY_DATE_OF_CHANGE", "2008" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_NATIONALITY_RECENT_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_CUSTODY_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_CUSTODY_LIST_1" );
    selenium.select( "$$DD$CLAIMANT_CUSTODY_DATE_OF_CHANGE", "label=5" );
    selenium.select( "$$MM$CLAIMANT_CUSTODY_DATE_OF_CHANGE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_CUSTODY_DATE_OF_CHANGE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_CUSTODY_SENTENCED_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_CUSTODY_SENTENCED_RELEASED_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_STUDENT_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_STUDENT_true" );
    selenium.select( "$$DD$CLAIMANT_STUDENT_DATE_OF_CHANGE", "label=1" );
    selenium.select( "$$MM$CLAIMANT_STUDENT_DATE_OF_CHANGE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_STUDENT_DATE_OF_CHANGE", "2009" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_STUDENT_FULLTIME_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_UNEARNED_INCOME_CHANGE_true" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_UNEARNED_INCOME_PASSPORT_STATUS_1" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_UNEARNED_INCOME_PASSPORT_LIST_1" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_2" );
    selenium.select( "$$DD$CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_DATE", "label=1" );
    selenium.select( "$$MM$CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_DATE", "label=January" );
    selenium.type( "$$YY$CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_DATE", "2011" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_FREQUENCY_LIST_4" );
    selenium.type( "name=$$CLAIMANT_UNEARNED_INCOME_PASSPORT_IS_AMOUNT", "500" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=CLAIMANT_UNEARNED_INCOME_BENEFIT_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=CLAIMANT_UNEARNED_INCOME_PENSION_TYPE_CHANGE_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=CLAIMANT_SAVINGS_CHANGE_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "id=CLAIMANT_EARNED_INCOME_CHANGE_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );

    selenium.click( "id=PARTNER_START_BOOLEAN_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );

    selenium.click( "id=PEOPLE_START_BOOLEAN_false" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );

    selenium.click( "SUPP_MAKING_THE_CHANGE_1" );
    selenium.click( "TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "name=$$ANY_OTHER_INFO", "NETSOL TEST" );
    selenium.click( "name=TNBnextButton" );
    selenium.waitForPageToLoad( "30000" );
    selenium.click( "link=Report an Incident" );
    selenium.waitForPageToLoad( "30000" );
    selenium.type( "name=TNSA_INCIDENT_REPORT_DESCRIPTION", "Integrations Claim 1" );
    selenium.click( "id=becsSubmitIncident" );
    selenium.waitForPageToLoad( "30000" );

  }

  public void close( ) throws Exception {
    selenium.stop( );
  }
}