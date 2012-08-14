package com.core;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

  public ButtonListener( Component... components ) {

  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource( ) == editTestButton || e.getSource( ) == editTestMenuItem )
      editTest( );
    else if ( e.getSource( ) == screenshotCheckbox )
      setSpecialCommand( "screenshotCheckbox" );
    else if ( e.getSource( ) == validateHTMLCheckbox )
      setSpecialCommand( "validateHTMLCheckbox" );
    else if ( e.getSource( ) == validateCSSCheckbox )
      setSpecialCommand( "validateCSSCheckbox" );
    else if ( e.getSource( ) == testDirMenuItem )
      openTestDir( );
    else if ( e.getSource( ).equals( quitMenuItem ) )
      quit( );
    else if ( e.getSource( ) == setTestDirMenuItem )
      setTestDir( );
    else if ( e.getSource( ) == setBrowserFileMenuItem )
      setBrowserFile( );
    else if ( e.getSource( ) == specialCommandsPropertiesMenuItem )
      specialCommandProperties( );
    else if ( e.getSource( ) == selPropertiesMenuItem )
      selProperties( );
    else if ( e.getSource( ) == systemPropertiesMenuItem )
      systemProperties( );
    else if ( e.getSource( ) == openSpecialDirMenuItem )
      openSpecialDir( );
    else if ( e.getSource( ) == openSelLogMenuItem )
      openSelLog( );
    else if ( e.getSource( ) == addPasswordMenuItem )
      addPassword( );
  }

}
