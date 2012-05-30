package com.core.validator;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.rexsl.w3c.Validator;
import com.rexsl.w3c.ValidatorBuilder;
import com.rexsl.w3c.ValidationResponse;

public class HTMLValidator implements Validator {

	private String uri;
	private URLConnection connect;
	private HttpURLConnection connection;
	private InputStream in;
	
	public HTMLValidator( String validatorURI ) {
		this.uri = validatorURI;
		
		
	}
	
	public ValidationResponse validate( String document ) {
		
		try {
			URL url = new URL( uri + "?output=soap12&fragment=" + document );
			System.out.println( url.toString( ) );
			connect = url.openConnection( );
			connection = ( HttpURLConnection ) connect;
			connection.setDoOutput( true );
			connection.setRequestMethod( "GET" );
		
			in = connection.getInputStream( );

			BufferedReader rd = new BufferedReader(new InputStreamReader(in));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null)
			{
			sb.append(line + "\n");
			}
			rd.close();
			System.out.println(sb.toString());
			} catch (Exception e)
			{
			e.printStackTrace();
			}
		
		return null;
	}
	
	public static void main( String [] args ) {
		HTMLValidator html = new HTMLValidator( "http://localhost/w3c-validator/check" );
		html.validate( "<!DOCTYPE html><html><body><h1>My First Heading</h1><p>My first paragraph.</p></body></html>" );
	}
	
}
