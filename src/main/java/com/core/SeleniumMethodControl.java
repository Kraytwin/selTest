package com.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumMethodControl {

  private String navName;
  private DefaultSelenium sel;
  private SeleniumMethod method;
  private String[ ] args;
  private int status;
  static Logger log = Logger.getLogger( "LogTest" );

  public SeleniumMethodControl( String nameIn ) {
    this.navName = nameIn;
  }

  public void setNewMethod( SeleniumMethod methodIn ) {
    // Initialise status
    status = 9;
    this.method = methodIn;
    if ( method.containsArguments( ) ) {
      args = method.getArguments( );
    }
  }

  /**
   * This will run the contained method with any arguments that it contains. The returned value
   * depends on whether the method is looking
   * for text or just running a method.
   * 
   * @return int
   *         0 - Method did not complete successfully
   *         1 - Method completed successfully
   *         2 - Text check where text was not found
   *         3 - Text check where text was found
   *         4 - Text check contained no arguments - Possibly incorrectly configured
   *         5 - Wait without a duration
   *         6 - Wait with a duration
   *         7 - Wait failed due to an issue with arguments
   *         8 - Wait was interrupted
   * @throws InterruptedException
   */
  public boolean runMethod( int index ) {
    int status;
    if ( method.isCheck( ) ) {
      if ( method.isTextCheck( ) ) {
        status = this.runTextCheck( );
      } else {
        // XXX Need to implement
        status = 10;
      }
    } else if ( method.isWait( ) ) {
      status = this.runWait( );
    } else if ( method.isGet( ) ) {
      // XXX Need to implement
      status = 10;
    } else {
      status = this.runNavMethod( );
    }

    return this.logStatus( status, index );
  }

  private int runTextCheck( ) {
    if ( method.containsArguments( ) ) {
      if ( sel.isTextPresent( args[ 0 ] ) ) {
        return 3;
      } else {
        return 2;
      }
    }
    return 4;
  }

  private int runWait( ) {
    try {
      if ( method.containsArguments( ) ) {
        if ( args.length > 1 ) {
          sel.wait( Long.parseLong( args[ 0 ] ), Integer.parseInt( args[ 1 ] ) );
        } else {
          sel.wait( Long.parseLong( args[ 0 ] ) );
        }
        return 6;
      } else {
        sel.wait( );
        return 5;
      }
    } catch ( NumberFormatException e ) {
      log.error( e );
      e.printStackTrace( );
      return 7;
    } catch ( InterruptedException e ) {
      log.error( e );
      e.printStackTrace( );
      return 8;
    }
  }

  /**
   * Runs the Selenium method unless it is the isTextPresent method. The initial assumption is that
   * all parameters used are Strings
   * since Selenium almost solely deals with String inputs (With the exception of the wait commands
   * which are dealt with separately)
   * 
   * @return an int corresponding to the output status
   *         -1 - Locator not found
   *         0 - Method did not complete successfully
   *         1 - Method completed successfully
   */
  private int runNavMethod( ) {
    Class<?> c = sel.getClass( );
    Method m;
    try {
      // The parameters for Selenium will almost always be a String input
      Class<String>[ ] parTypes = new Class[ ] { String[ ].class };
      m = c.getMethod( method.getName( ), parTypes );
      if ( m.isAccessible( ) ) {
        if ( method.hasLocator( ) ) {
          if ( method.hasMultipleLocators( ) ) {
            if ( !sel.isElementPresent( args[ 0 ] ) ) {
              return -1;
            }
          }
          if ( !sel.isElementPresent( args[ 0 ] ) ) {
            return -1;
          }
        }
        m.invoke( sel, ( Object ) args );
        return 1;
      }
    } catch ( SecurityException e ) {
      log.error( e );
      e.printStackTrace( );
    } catch ( NoSuchMethodException e ) {
      log.error( e );
      e.printStackTrace( );
    } catch ( IllegalArgumentException e ) {
      log.error( e );
      e.printStackTrace( );
    } catch ( IllegalAccessException e ) {
      log.error( e );
      e.printStackTrace( );
    } catch ( InvocationTargetException e ) {
      log.error( e );
      e.printStackTrace( );
    }
    return 0;
  }

  private boolean logStatus( int status, int index ) {
    switch ( status ) {
    // Probably make a static SystemMessageManager class and send it messages
    // XXX Make this return the status instead
      case -1 :
        log.error( "Method " + index + ", " + method.getName( ) + ", in " + navName + "was not found on "
            + this.getPageToString( ) );
        return false;
      case 0 :
        log.error( "Method " + index + ", " + method.getName( ) + ", in " + navName
            + "did not complete successfully on " + this.getPageToString( ) );
        return false;
      case 1 :
        log.info( "Method " + index + ", " + method.getName( ) + ", in " + navName + " completed successfully on "
            + this.getPageToString( ) );
        break;
      case 2 :
        log.info( "Search " + index + ", in " + navName + " could not find the text " + method.getArgumentsToString( )
            + " on " + this.getPageToString( ) );
        break;
      case 3 :
        log.info( "Search " + index + ", in " + navName + " found the text " + method.getArgumentsToString( ) + " on "
            + this.getPageToString( ) );
        break;
      case 4 :
        log.error( "Method " + index + ", " + method.getName( ) + ", in " + navName
            + " was not run as it did not contain any arguments. " );
        return false;
      case 5 :
        log.info( "Wait " + index + ", in " + navName + " completed successfully on " + this.getPageToString( ) );
        break;
      case 6 :
        log.info( "Wait " + index + " with duration, in " + navName + " completed successfully on "
            + this.getPageToString( ) );
        break;
      case 7 :
        log.error( "Wait " + index + ", in " + navName + " was not run as it did not contain any arguments. " );
        return false;
      case 8 :
        log.warn( "Wait " + index + ", in " + navName + " was interurrpted but will system will continue. " );
        break;
      case 9 :
        log.error( "Method " + index + ", " + method.getName( ) + ", in " + navName + ": Error: Status not recorded." );
        break;
      default :
        log.error( "Method " + index + ", " + method.getName( ) + ", in " + navName + ": Unknown outcome ocrrured." );
        return false;
    }
    return true;

  }

  // XXX May need to update this to include an optional header name to make it clearer.
  private String getPageToString( ) {
    return sel.getTitle( ) + ", " + sel.getLocation( );
  }

}
