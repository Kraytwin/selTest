package com.core;

public class SeleniumMethod {

  private String name;
  private String[ ] args = new String[ 0 ];
  private final boolean CONTAINS_ARGUMENTS;
  private boolean IS_TEXT_CHECK = false, IS_CHECK = false;
  private boolean IS_WAIT = false, IS_GET = false;
  private boolean HAS_LOCATOR = false, HAS_MULTIPLE_LOCATORS = false;

  public SeleniumMethod( String nameIn, String[ ] args ) {
    this.name = nameIn;

    if ( args.length > 0 ) {
      this.args = args;
      CONTAINS_ARGUMENTS = true;
    } else {
      CONTAINS_ARGUMENTS = false;
    }
    this.checkMethodName( );
    this.checkHasLocator( );
  }

  public SeleniumMethod( String nameIn ) {
    this.name = nameIn;
    CONTAINS_ARGUMENTS = false;
    this.checkMethodName( );
  }

  private void checkMethodName( ) {
    // Going to check if it is a method that checks for conditions
    if ( name.startsWith( "is" ) ) {
      // The most common is
      if ( name.equals( "isTextPresent" ) ) {
        IS_TEXT_CHECK = true;
        IS_CHECK = true;
        // No other way to really do it than
      } else if ( Character.isUpperCase( name.charAt( 3 ) ) ) {
        IS_CHECK = true;
      }
      // Now to check for the wait condition
    } else if ( name.equals( "wait" ) ) {
      IS_WAIT = true;
    } else if ( name.startsWith( "get" ) ) {
      IS_GET = true;
    }
  }

  /**
   * This will check if the method uses a locator and updated the HAS_LOCATOR boolean
   * This has the most chance of being outdated as newer versions of Selenium come out.
   * This is a horrendous way to do this but the only way I can think of without using JavaCC.
   */
  private void checkHasLocator( ) {
    if ( name.equals( "isOrdered" ) ) {
      HAS_LOCATOR = true;
      HAS_MULTIPLE_LOCATORS = true;
    } else if ( name.equals( "addSelection" ) || name.equals( "assignId" ) || name.equals( "attachFile" )
        || name.equals( "check" ) || name.equals( "click" ) || name.equals( "clickAt" ) || name.equals( "contextMenu" )
        || name.equals( "contextMenuAt" ) || name.equals( "doubleClick" ) || name.equals( "doubleClickAt" )
        || name.equals( "dragAndDrop" ) || name.equals( "dragAndDropToObject" ) || name.equals( "dragdrop" )
        || name.equals( "fireEvent" ) || name.equals( "focus" ) || name.equals( "getAttribute" )
        || name.equals( "getElementHeight" ) || name.equals( "getElementIndex" )
        || name.equals( "getElementPositionLeft" ) || name.equals( "getElementPositionTop" )
        || name.equals( "getElementWidth" ) || name.equals( "getExpression" ) || name.equals( "getSelectedId" )
        || name.equals( "getSelectedIds" ) || name.equals( "getSelectedIndex" ) || name.equals( "getSelectedIndexes" )
        || name.equals( "getSelectedLabel" ) || name.equals( "getSelectedLabels" ) || name.equals( "getSelectedValue" )
        || name.equals( "getSelectedValues" ) || name.equals( "getSelectOptions" ) || name.equals( "getTable" )
        || name.equals( "getText" ) || name.equals( "getValue" ) || name.equals( "getXpathCount" )
        || name.equals( "highlight" ) || name.equals( "isChecked" ) || name.equals( "isEditable" )
        || name.equals( "isElementPresent" ) || name.equals( "isSomethingSelected" ) || name.equals( "isVisible" )
        || name.equals( "keyDown" ) || name.equals( "keyPress" ) || name.equals( "keyUp" ) || name.equals( "mouseDown" )
        || name.equals( "mouseDownAt" ) || name.equals( "mouseDownRight" ) || name.equals( "mouseDownRightAt" )
        || name.equals( "mouseMove" ) || name.equals( "mouseMoveAt" ) || name.equals( "mouseOut" )
        || name.equals( "mouseOver" ) || name.equals( "mouseUp" ) || name.equals( "mouseUpAt" )
        || name.equals( "mouseUpRight" ) || name.equals( "mouseUpRightAt" ) || name.equals( "removeAllSelections" )
        || name.equals( "removeSelection" ) || name.equals( "select" ) || name.equals( "selectFrame" )
        || name.equals( "setCursorPosition" ) || name.equals( "submit" ) || name.equals( "type" )
        || name.equals( "typeKeys" ) || name.equals( "uncheck" ) ) {
      HAS_LOCATOR = true;
    }
  }

  public String getName( ) {
    return name;
  }

  public String[ ] getArguments( ) {
    return args;
  }

  /**
   * Returns the arguments that were used in String form.
   * 
   * @return the arguments that were used, "" otherwise.
   */
  public String getArgumentsToString( ) {
    String arguments = "";
    if ( CONTAINS_ARGUMENTS ) {
      for ( String a : args ) {
        arguments += "\"" + a + "\" ";
      }
      return arguments;
    } else {
      return "";
    }
  }

  public boolean isTextCheck( ) {
    if ( IS_TEXT_CHECK ) {
      return true;
    }
    return false;
  }

  public boolean isCheck( ) {
    if ( IS_CHECK ) {
      return true;
    }
    return false;
  }

  public boolean isGet( ) {
    if ( IS_GET ) {
      return true;
    }
    return false;
  }

  public boolean isWait( ) {
    if ( IS_WAIT ) {
      return true;
    }
    return false;
  }

  public boolean hasLocator( ) {
    if ( HAS_LOCATOR ) {
      return true;
    }
    return false;
  }

  public boolean hasMultipleLocators( ) {
    if ( HAS_MULTIPLE_LOCATORS ) {
      return true;
    }
    return false;
  }

  public boolean containsArguments( ) {
    if ( CONTAINS_ARGUMENTS ) {
      return true;
    }
    return false;
  }

}
