package com.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.forms.SelMain;

public class SelMainController {

  private SelMain sel;
  private ActionListener buttonListener;
  private ListSelectionListener listListener;

  public SelMainController( ) {
    sel = new SelMain( );

    // Now to initialise the listeners.
    this.initListeners( );

    // And now to use the listeners.
    sel.addActionListeners( buttonListener );
    sel.addListSelectionListeners( listListener );
  }

  private void initListeners( ) {
    buttonListener = new ActionListener( ) {

      public void actionPerformed( ActionEvent e ) {
        if ( e.getSource( ) == sel.getComponent( "editTestButton" )
            || e.getSource( ) == sel.getComponent( "editTestMenuItem" ) )
          editTest( );
        else if ( e.getSource( ) == sel.getComponent( "screenshotCheckbox" ) )
          setSpecialCommand( "screenshotCheckbox" );
        else if ( e.getSource( ) == sel.getComponent( "validateHTMLCheckbox" ) )
          setSpecialCommand( "validateHTMLCheckbox" );
        else if ( e.getSource( ) == sel.getComponent( "validateCSSCheckbox" ) )
          setSpecialCommand( "validateCSSCheckbox" );
        else if ( e.getSource( ) == sel.getComponent( "testDirMenuItem" ) )
          openTestDir( );
        else if ( e.getSource( ) == sel.getComponent( "quitMenuItem" ) )
          quit( );
        else if ( e.getSource( ) == sel.getComponent( "setTestDirMenuItem" ) )
          setTestDir( );
        else if ( e.getSource( ) == sel.getComponent( "setBrowserFileMenuItem" ) )
          setBrowserFile( );
        else if ( e.getSource( ) == sel.getComponent( "specialCommandsPropertiesMenuItem" ) )
          specialCommandProperties( );
        else if ( e.getSource( ) == sel.getComponent( "selPropertiesMenuItem" ) )
          selProperties( );
        else if ( e.getSource( ) == sel.getComponent( "systemPropertiesMenuItem" ) )
          systemProperties( );
        else if ( e.getSource( ) == sel.getComponent( "openSpecialDirMenuItem" ) )
          openSpecialDir( );
        else if ( e.getSource( ) == sel.getComponent( "openSelLogMenuItem" ) )
          openSelLog( );
        else if ( e.getSource( ) == sel.getComponent( "addPasswordMenuItem" ) )
          addPassword( );
      }
    };

    listListener = new ListSelectionListener( ) {

      public void valueChanged( ListSelectionEvent e ) {

        if ( !e.getValueIsAdjusting( ) )
          if ( e.getSource( ) == sel.getComponent( "browserList" ) )
            updateBrowserList( );
          if ( e.getSource( ) == sel.getComponent( "siteList" ) )
            updateSiteList( );
          if ( e.getSource( ) == sel.getComponent( "testList" ) )
            updateTestList( );
      }

    };
  }

  private void addPassword( ) {
    // TODO Auto-generated method stub

  }

  private void openSelLog( ) {
    // TODO Auto-generated method stub

  }

  private void openSpecialDir( ) {
    // TODO Auto-generated method stub

  }

  private void systemProperties( ) {
    // TODO Auto-generated method stub

  }

  private void selProperties( ) {
    // TODO Auto-generated method stub

  }

  private void specialCommandProperties( ) {
    // TODO Auto-generated method stub

  }

  private void setBrowserFile( ) {
    // TODO Auto-generated method stub

  }

  private void setTestDir( ) {
    // TODO Auto-generated method stub

  }

  private void quit( ) {
    sel.quit( );
  }

  private void openTestDir( ) {
    // TODO Auto-generated method stub

  }

  private void setSpecialCommand( String special ) {
    // TODO Auto-generated method stub

  }

  private void editTest( ) {
    // TODO Auto-generated method stub

  }
  
  private void updateSiteList( ) {
    // TODO Auto-generated method stub
    
  }

  private void updateTestList( ) {
    // TODO Auto-generated method stub
    
  }

  private void updateBrowserList( ) {
    // TODO Auto-generated method stub
    
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main( String args[] ) {
    /*
     * Set the Nimbus look and feel
     */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels( ) ) {
        if ( "Nimbus".equals( info.getName( ) ) ) {
          javax.swing.UIManager.setLookAndFeel( info.getClassName( ) );
          break;
        }
      }
    } catch ( ClassNotFoundException ex ) {
      java.util.logging.Logger.getLogger( SelMain.class.getName( ) ).log( java.util.logging.Level.SEVERE, null, ex );
    } catch ( InstantiationException ex ) {
      java.util.logging.Logger.getLogger( SelMain.class.getName( ) ).log( java.util.logging.Level.SEVERE, null, ex );
    } catch ( IllegalAccessException ex ) {
      java.util.logging.Logger.getLogger( SelMain.class.getName( ) ).log( java.util.logging.Level.SEVERE, null, ex );
    } catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
      java.util.logging.Logger.getLogger( SelMain.class.getName( ) ).log( java.util.logging.Level.SEVERE, null, ex );
    }
    // </editor-fold>

    /*
     * Create and display the form
     */
    java.awt.EventQueue.invokeLater( new Runnable( ) {

      public void run( ) {
        new SelMain( ).setVisible( true );
      }
    } );
  }

}
