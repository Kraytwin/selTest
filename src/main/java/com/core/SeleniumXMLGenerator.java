package com.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SeleniumXMLGenerator {

  private File file, fileOut;
  private String url;
  
  public SeleniumXMLGenerator( File fileIn, File fileOut) {
    file = fileIn;
    this.fileOut = fileOut;   
  }
  public SeleniumXMLGenerator( File fileIn, File fileOut, String urlIn) {
	    file = fileIn;
	    this.fileOut = fileOut;
	    url = urlIn;
	  }
  
  public void SeleniumXMLOutput( ) {
    boolean completedNavUnit = true;
    String lineIn, navUnitText = "";
    try {
      BufferedReader br = new BufferedReader( new FileReader( file ) );
      BufferedWriter bw = new BufferedWriter( new FileWriter( fileOut ) );
      String name = file.getName( ).split("\\.")[0];
      //This is a bit messy but is to remove some extra bytes that cause a Fatal Error from content before the actual XML
      String startingXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n";
      startingXML = startingXML.trim().replaceFirst("^([\\W]+)<","<");
      bw.write( startingXML );
      bw.write( "<Sequence xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + 
"\nxsi:SchemaLocation=\"XMLSchema.xsd\" name=\"" + name );
      if( url != null ) {
    	  bw.write( "\" URL=\"" + url);
      }		
		bw.write( "\">\r\n" );
      while( (lineIn = br.readLine( ) ) != null ) {
    	  if( completedNavUnit ) {
    		navUnitText = "  <NavigationUnit name=UNNAMED>\r\n";
    		completedNavUnit = false;
    	  }
        System.out.println( lineIn );
        lineIn = lineIn.trim( );
        lineIn = lineIn.replaceAll("\t", "");
        lineIn = lineIn.replaceAll("  ", "");
        if ( lineIn.startsWith( "//" ) ) {
          //For now all comments will be ignored
          //bw.write( "<!-- " + lineIn.replace( "//", "" ) + " -->\n" );
        } else if( lineIn.startsWith( "/*" ) ) {
        	//Do nothing
        	while( !(lineIn = br.readLine( ) ).contains("*/") ) {
        		//Again do nothing as the script does not require it.
        		//XXX May cause errors if a line has */ at the beginning
        	}
        	//XXX Should really check for javadoc
        } else if ( lineIn.startsWith( "selenium." ) ) {
        	//XXX Need to add a check that it isn't a screenshot function.
          System.out.println( "Also here!" );
          navUnitText += ( this.buildMethodXML( lineIn, 9 ) );
        } else if ( lineIn.startsWith( "verifyTrue" ) ) {
          navUnitText += ( this.buildMethodXML( lineIn, 20 ) );
        } else if( lineIn.startsWith( "Assert" ) ) {
          navUnitText += ( this.buildMethodXML( lineIn, 16 ) );
          //For now this method will always be the screenshot name, etc.
        } else { //if ( !lineIn.equals( "" ) ) {
          if( !lineIn.equals( "" ) ) {
          navUnitText = navUnitText.replace( "UNNAMED", this.getTextBetweenBrackets(lineIn) );
          }
          System.out.println( navUnitText );
        	//After this the navigation unit is completed so we can add the closing tag.
          navUnitText += "  </NavigationUnit>\r\n";
          completedNavUnit = true;
          bw.write( navUnitText );
        }
      }
      bw.write("</Sequence>");
      bw.close( );
    
    } catch ( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  private String buildMethodXML( String lineIn, int index ) {
	String methodXML, methodName, text;
    methodName = this.getMethodName( lineIn, index );
    text = this.getTextBetweenBrackets( lineIn );
    if( text.equals( "" ) ) {
      methodXML = "    <MethodName type=\"" + methodName + "\"/>\r\n";
    } else {
      methodXML = "    <MethodName type=\"" + methodName + "\">\r\n";
        methodXML += ( this.addParts( text ) );
      methodXML += "</MethodName>\r\n";
    }
    
    return methodXML;
  }
  
  private int locateNextQuote( String line ) {
    Pattern escapesP = Pattern.compile("[^\\\\](\\\\)*\\\",");
    Matcher escapesM = escapesP.matcher( line );
    int closingQuoteIndex = line.indexOf( "\"", 1 );
    
    while ( escapesM.find( ) ) {
      String firstEscapeQuote = escapesM.group( );
      int escapedQuoteBeginning = line.indexOf( firstEscapeQuote );
      int escapedQuoteIndex = escapedQuoteBeginning + firstEscapeQuote.length( ) -1;
      if ( closingQuoteIndex != escapedQuoteIndex ) {
        escapesM = escapesP.matcher( line.substring( escapedQuoteIndex ) );
      }
    } 
    
    return closingQuoteIndex;
    
  }
  
  private String getTextBetweenBrackets( String lineIn ) {
    int typeNumber = lineIn.indexOf( "(" );
    int lastParenth = lineIn.lastIndexOf( ")" );
    String text = lineIn.substring( typeNumber + 1, lastParenth ).trim( );
    return text;
  }
  
  private String getMethodName( String lineIn, int index ) {
	  int typeNumber = lineIn.indexOf( "(" );
	  String methodName = lineIn.substring( index, typeNumber );
    return methodName;
  }

  
  private String addParts( String text ) {
    int closingQuote, i = 1;
    boolean found = true;
    String navigationUnitBodyText = "";
    while ( found ) {
      closingQuote = this.locateNextQuote( text );
      found = text.contains( "\",");
      navigationUnitBodyText += this.addPartXML( text, i, closingQuote );
      if ( closingQuote != ( text.length( ) - 1 ) ) {
        text = text.substring( closingQuote + 2 ).trim( );
      } else {
        text = text.substring( closingQuote ).trim( );
      }
      i++;             
    }
    navigationUnitBodyText += "    ";
    return navigationUnitBodyText;
    
  }
  
  private String addPartXML( String text, int i, int closingQuote ) {
    String returnedText = "";
    returnedText = "      <Part num=\"" + i + "\">" + text.substring( 1, closingQuote ) + "</Part>\r\n";
    return returnedText;    
  }
  
  
}
