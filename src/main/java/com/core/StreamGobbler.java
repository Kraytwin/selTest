package com.core;

import java.io.*;

class StreamGobbler extends Thread {

  InputStream is;
  String type;
  boolean siteStarted, siteStopped, checkOutput;
  int claimsSubmitted;
  private String siteStartedText, siteStoppedText, claimSubmittedText;

  StreamGobbler( InputStream is, String type, String siteStartedTextIn, String siteStoppedTextIn,
      String claimsSubmittedTextIn, boolean checkOutputIn ) {
    this.is = is;
    this.type = type;
    siteStarted = false;
    siteStopped = false;
    claimsSubmitted = 0;
    this.siteStartedText = siteStartedTextIn;
    this.siteStoppedText = siteStoppedTextIn;
    this.claimSubmittedText = claimsSubmittedTextIn;
    this.checkOutput = checkOutputIn;
  }

  public void run( ) {
    try {
      BufferedReader br = new BufferedReader( new InputStreamReader( is ) );
      String line = null;
      while ( ( line = br.readLine( ) ) != null )
        /*
         * if( checkOutput ) {
         * if( line.startsWith(siteStartedText) ) {
         * siteStarted = true;
         * //Can't be stopped right now so just to make sure
         * siteStopped = false;
         * } else if (line.startsWith(siteStoppedText) ){
         * siteStopped = true;
         * //Can't be started right now to just to make sure
         * siteStarted = false;
         * } else if (line.startsWith(claimSubmittedText) ){
         * claimsSubmitted++;
         * }
         * }
         */
        System.out.println( type + ">" + line );
    } catch ( IOException ioe ) {
      ioe.printStackTrace( );
    }
  }

  public boolean isStarted( ) {
    return siteStarted;
  }

  public boolean isStopped( ) {
    return siteStopped;
  }

  public int getNumberClaimsSubmitted( ) {
    return claimsSubmitted;
  }
}