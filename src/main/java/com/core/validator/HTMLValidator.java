package com.core.validator;


public class HTMLValidator extends StandardValidator {

  private boolean isFragment = true;
  private String uri, outputFormat, charset, doctype, verbose, debug, ss;

  public HTMLValidator( String validatorURI ) {
    super( "validatorURI" );
    this.uri = validatorURI;
    outputFormat = "soap12";

  }

  /**
   * If true will set the validator to use fragments. If false it will use URIs.
   * 
   * @param val
   */
  public void setFragment( boolean val ) {
    isFragment = val;
  }

  /**
   * Sets the character encoding. This is ignored if the content is a fragment. This can be unset by
   * entering a blank string.
   * 
   * @param charset
   */
  public void setCharset( String charset ) {
    this.charset = setParameter( "charset", charset );
  }

  /**
   * Sets the doctype. This is ignored if the content is a fragment. This can be unset by entering a
   * blank string.
   * 
   * @param doctype
   */
  public void setDoctype( String doctype ) {
    this.doctype = setParameter( "doctype", doctype );
  }

  /**
   * Makes explanations, error messages and other diagnostics more verbose.
   * Does not have any impact with SOAP and by default is off.
   * 
   * @param val
   */
  public void setVerbose( boolean val ) {
    if ( val ) {
      this.verbose = setParameter( "verbose", "1" );
    } else {
      verbose = "";
    }
  }

  /**
   * Adds in extra debug information into the response. Is off by default.
   * 
   * @param val
   */
  public void setDebug( boolean val ) {
    if ( val ) {
      this.debug = setParameter( "debug", "1" );
    } else {
      debug = "";
    }
  }

  /**
   * Displays the source after the validation.
   * Does not have any impact with SOAP and by default is off.
   * 
   * @param val
   */
  public void setShowSource( boolean val ) {
    if ( val ) {
      this.ss = setParameter( "ss", "1" );
    } else {
      ss = "";
    }
  }

  // Output parameter is not dealt with as it only works with the web interface.

  public String generateQuery( ) {
    String query = "?output=" + outputFormat + charset + doctype + verbose + debug + ss + "&";
    if ( isFragment ) {
      return query + "fragment=";
    } else {
      return query + "uri=";
    }

  }

}
