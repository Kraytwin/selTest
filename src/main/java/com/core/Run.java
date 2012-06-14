package com.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.hardcodeshit.*;

public class Run {

  public static void main( String[ ] args ) {

    ArrayList<Browser> browsers = new ArrayList<Browser>( );
    // XXX Sort all this out soon.
    // browsers.add( new Browser(
    // "Safari","safari","/Applications/Safari.app/Contents/MacOS/Safari","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "Firefox3.6","chrome","/Applications/Firefox3.6.app/Contents/MacOS/firefox-bin","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    browsers.add( new Browser( "Firefox8", "chrome", "/Applications/Firefox8.app/Contents/MacOS/firefox-bin",
        "127.0.0.1", "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "Firefox5","chrome","/Applications/Firefox5.app/Contents/MacOS/firefox-bin","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "Firefox2","chrome","/Applications/Firefox2.app/Contents/MacOS/firefox-bin","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "Opera","opera","/Applications/Opera.app/Contents/MacOS/firefox-bin","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "GoogleChrome","googlechrome","/Applications/Chrome.app/Contents/MacOS/Safari","127.0.0.1",
    // "/Users/stephenfallis/Desktop/random/" ) );
    // browsers.add( new Browser(
    // "IE9","iexploreproxy","C:\\Program Files\\Internet Explorer\\iexplore.exe","10.0.0.129",
    // "C:\\Users\\IETester\\Desktop\\Screenshots\\" ) );
    // browsers.add( new Browser(
    // "IE6","iexploreproxy","C:\\Program Files\\Internet Explorer\\IEXPLORE.exe","10.0.0.126",
    // "C:\\Documents and Settings\\IE User\\Desktop\\Screenshots\\") );
    // browsers.add( new Browser(
    // "IE7","iexploreproxy","C:\\Program Files\\Internet Explorer\\iexplore.exe","10.0.0.127",
    // "C:\\Documents and Settings\\IE User\\Desktop\\Screenshots\\" ) );
    // browsers.add( new Browser(
    // "IE8","iexploreproxy","C:\\Program Files\\Internet Explorer\\iexplore.exe","10.0.0.128",
    // "C:\\Documents and Settings\\IE User\\Desktop\\Screenshots\\" ) );
    // browsers.add( new Browser( "Firefox", "chrome",
    // "C:\\Program Files\\Mozilla Firefox\\firefox.exe", "127.0.0.1",
    // "C:\\Documents and Settings\\Steve-O\\Desktop\\Screenshots\\"));

    // DurhamTest st = new DurhamTest( );
    DocGenTest st = new DocGenTest( );
    // BBCTest st = new BBCTest();
    // IntegrationTests st = new IntegrationTests();
    // SeleniumTest2 st = new SeleniumTest2( );
    // PrepopQuestions st = new PrepopQuestions( );
    // ChangeAdminQuestions st = new ChangeAdminQuestions( );
    // RochdaleChange st = new RochdaleChange( );
    // BlueBadgePages st = new BlueBadgePages( );
    // BlueBadgeAdmin st = new BlueBadgeAdmin( );
    try {
      SiteList sites = new SiteList( new File( "/Users/stephenfallis/Desktop/sites.txt" ) );
      SiteHandler sh;
      for ( Browser currentBrowser : browsers ) {
        st.setUp( currentBrowser );
        for ( String site : sites.getSiteList( ) ) {
          sh = new SiteHandler( site );
          try {
            sh.start( );
            st.testNew( site );
            sh.stop( );
          } catch ( Exception e ) {
            e.printStackTrace( );
            // If anything happens while when it is running through a site we
            // just want it to stop the site and then move to the next one.
            sh.stop( );
          }
        }
        st.close( );
      }
    } catch ( Exception e ) {
      e.printStackTrace( );
    }// */
    /*
     * for( Browser currentBrowser:browsers ) {
     * st.setUp( currentBrowser );
     * String site = "test";
     * try {
     * st.testNew( site );
     * } catch ( InterruptedException e ) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * } catch ( IOException e ) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * }
     */
  }
}
