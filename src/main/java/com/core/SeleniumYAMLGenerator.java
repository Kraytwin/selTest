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

public class SeleniumYAMLGenerator {

  private File file, fileOut;
  private String url;
  private int indentLevel = 0;

  private final String indent = "    ";
  // This is for list items
  private final String listIndent = "  - ";
  // This isn't really needed but I think it looks better than \n continuously
  private final String lineBreak = "\r\n";

  public SeleniumYAMLGenerator( File fileIn, File fileOut ) {
    file = fileIn;
    this.fileOut = fileOut;
  }

  public SeleniumYAMLGenerator( File fileIn, File fileOut, String urlIn ) {
    file = fileIn;
    this.fileOut = fileOut;
    url = urlIn;
  }

  public void SeleniumYAMLOutput( ) {
    boolean completedNavUnit = true;
    String lineIn, navUnitText = "";
    try {
      BufferedReader br = new BufferedReader( new FileReader( file ) );
      BufferedWriter bw = new BufferedWriter( new FileWriter( fileOut ) );
      String name = file.getName( ).split( "\\." )[ 0 ];
      // Should never have an indent
      bw.write( "name: " + name + lineBreak );
      if ( url != null ) {
        // Should never have an indent
        bw.write( "url: " + url + lineBreak );
      }
      while ( ( lineIn = br.readLine( ) ) != null ) {
        lineIn = lineIn.replaceAll( "(?m)^[ \t]*\r?\n", "" );
        if ( completedNavUnit && !lineIn.replaceAll( "\\s", "" ).equals( "" ) ) {
          // Time to start a new nav unit
          navUnitText = "navigationUnits:" + lineBreak;
          this.increaseIndent( );
          navUnitText += this.indent( true ) + "name: UNNAMED" + lineBreak;
          navUnitText += this.indent( false ) + "methods:" + lineBreak;
          completedNavUnit = false;
        }
        lineIn = lineIn.trim( );
        if ( lineIn.startsWith( "//" ) ) {
          // For now all comments will be ignored
          // bw.write( lineIn.replace( "//", "#" ) );
        } else if ( lineIn.startsWith( "/*" ) ) {
          // Do nothing
          while ( ! ( lineIn = br.readLine( ) ).contains( "*/" ) ) {
            // Again do nothing as the script does not require it.
            // XXX May cause errors if a line has */ at the beginning
          }
          // XXX Should really check for javadoc
        } else if ( lineIn.startsWith( "selenium." ) ) {
          // XXX Need to add a check that it isn't a screenshot function.
          navUnitText += ( this.buildMethodYAML( lineIn, 9 ) );
        } else if ( lineIn.startsWith( "verifyTrue" ) ) {
          navUnitText += ( this.buildMethodYAML( lineIn, 20 ) );
        } else if ( lineIn.startsWith( "Assert" ) ) {
          navUnitText += ( this.buildMethodYAML( lineIn, 16 ) );
          // For now this method will always be the screenshot name, etc.
        } else { // if ( !lineIn.equals( "" ) ) {
          if ( !lineIn.equals( "" ) ) {
            navUnitText = navUnitText.replace( "UNNAMED", this.getTextBetweenBrackets( lineIn ) );
          }
          System.out.println( navUnitText );
          // After this the navigation unit is completed so we can decrease the indent
          this.decreaseIndent( );
          completedNavUnit = true;
          bw.write( navUnitText );
        }
      }
      bw.close( );

    } catch ( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    } catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    }

  }

  private String buildMethodYAML( String lineIn, int index ) {
    String methodYAML, methodName, text;
    methodName = this.getMethodName( lineIn, index );
    text = this.getTextBetweenBrackets( lineIn );
    this.increaseIndent( );
    methodYAML = this.indent( true ) + "name: " + methodName + lineBreak;
    methodYAML += this.indent( false ) + "inputs:" + lineBreak;
    if ( !text.equals( "" ) ) {
      // Need to add the inputs now
      this.increaseIndent( );
      methodYAML += ( this.addParts( text ) );
      this.decreaseIndent( );
    }
    this.decreaseIndent( );

    return methodYAML;
  }

  private int locateNextQuote( String line ) {
    Pattern escapesP = Pattern.compile( "[^\\\\](\\\\)*\\\"," );
    Matcher escapesM = escapesP.matcher( line );
    int closingQuoteIndex = line.indexOf( "\"", 1 );

    while ( escapesM.find( ) ) {
      String firstEscapeQuote = escapesM.group( );
      int escapedQuoteBeginning = line.indexOf( firstEscapeQuote );
      int escapedQuoteIndex = escapedQuoteBeginning + firstEscapeQuote.length( ) - 1;
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
      found = text.contains( "\"," );
      navigationUnitBodyText += this.addPartYAML( text, i, closingQuote );
      if ( closingQuote != ( text.length( ) - 1 ) ) {
        text = text.substring( closingQuote + 2 ).trim( );
      } else {
        text = text.substring( closingQuote ).trim( );
      }
      i++;
    }
    return navigationUnitBodyText;

  }

  private String addPartYAML( String text, int i, int closingQuote ) {
    String returnedText = "";
    returnedText = this.indent( true ) + text.substring( 1, closingQuote ) + lineBreak;
    return returnedText;
  }

  private void increaseIndent( ) {
    indentLevel++;
  }

  private boolean decreaseIndent( ) {
    if ( indentLevel > 0 ) {
      indentLevel--;
      return true;
    }
    return false;
  }

  private String indent( boolean repeats ) {
    String currentIndent = "";
    if ( indentLevel > 0 ) {
      // Only want to indent up to the second last indent in the for loop
      // the final one may need to have the list character
      for ( int i = 1; i < indentLevel; i++ ) {
        currentIndent += indent;
      }
      if ( repeats ) {
        currentIndent += listIndent;
      } else {
        currentIndent += indent;
      }

    }
    return currentIndent;
  }
}
