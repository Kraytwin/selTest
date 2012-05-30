package com.core.validator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.rexsl.w3c.Validator;

public class StandardValidator implements Validator {

  private URLConnection connect;
  private HttpURLConnection connection;
  private InputStream in;
  private ValidationHandler val;
  private String uri, outputFormat, documentURI;

  public StandardValidator( String validatorURI ) {
    this.uri = validatorURI;
    outputFormat = "soap12";

  }

  /**
   * Takes the string that has been uploaded and runs a validation on it. This can be a URL or a
   * 
   * This does not currently support uploaded files
   */
  public ValidationHandler validate( String document ) {

    try {
      URL url = new URL( uri + this.generateQuery( ) + document );
      System.out.println( url.toString( ) );
      connect = url.openConnection( );
      connection = ( HttpURLConnection ) connect;
      connection.setDoOutput( true );
      connection.setRequestMethod( "GET" );

      BufferedReader rd = new BufferedReader( new InputStreamReader( connection.getInputStream( ) ) );
      StringBuffer sb = new StringBuffer( );
      String line;
      while ( ( line = rd.readLine( ) ) != null ) {
        sb.append( line + "\n" );
      }
      rd.close( );
      val = new ValidationHandler( sb.toString( ) );
    } catch ( Exception e ) {
      e.printStackTrace( );
    }

    return val;
  }

  // Currently output is not added as no other output except soap12 is handled.

  private String generateQuery( ) {
    return "?output=" + outputFormat + "&uri=";
  }

  public static void main( String[ ] args ) {
    StandardValidator html = new StandardValidator( "http://localhost/w3c-validator/check" );
    html.validate( "<!DOCTYPE html><html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>" );
  }

  protected String setParameter( String parameter, String content ) {
    String value = "";
    if ( content != null && !content.equals( "" ) ) {
      value = "&" + parameter + "=" + content;
    }
    return value;
  }

}
