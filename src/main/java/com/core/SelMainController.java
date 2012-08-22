package com.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.forms.SelMain;

public class SelMainController {

  private SelMain sel;
  private ActionListener buttonListener;
  private ListSelectionListener listListener;
  private ConfigSettings config = ConfigSettings.getInstance( );
  private File browserLocation, siteLocation, testDir;
  private BrowserHandler bh;
  private SiteList sl;
  private TestHandler th;
  private String fileFormat;

  public SelMainController( ) {
    // First need to get the relevant config settings
    browserLocation = new File( this.config.getProperty( "FILE_SYSTEM.BROWSER_FILE_LOCATION" ) );
    siteLocation = new File( this.config.getProperty( "FILE_SYSTEM.SITE_FILE_LOCATION" ) );
    testDir = new File( this.config.getProperty( "FILE_SYSTEM.TEST_DIR_LOCATION" ) );
    fileFormat = this.config.getProperty( "FILE_SYSTEM.TEST_FILE_FORMAT" );

    bh = new BrowserHandler( browserLocation );
    sl = new SiteList( siteLocation );
    th = new TestHandler( testDir, fileFormat );

    sel = new SelMain( );

    this.updateBrowserList( );
    this.updateSiteList( );
    this.updateTestList( );

    // Now to initialise the listeners.
    this.initListeners( );

    // And now to use the listeners.
    sel.addActionListeners( buttonListener );
    sel.addListSelectionListeners( listListener );

    sel.setVisible( true );
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
        else if ( e.getSource( ).equals( sel.getComponent( "quitMenuItem" ) ) )
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
          updateTestPreviewArea( );
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
    sel.updateSiteList( sl );

  }

  private void updateTestList( ) {
    sel.updateTestList( th );

  }

  private void updateBrowserList( ) {
    sel.updateBrowserList( bh.readBrowsers( ) );

  }

  private void updateTestPreviewArea( ) {
    boolean editable = false;
    String testText = "No test selected!";
    File testFile = sel.getSelectedTest( );
    if ( testFile != null ) {
      Test test = new Test( testFile );
      testText = test.toString( );
      editable = test.isTestValid( );
    }
    sel.updateTestPreviewArea( testText, editable );
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
        new SelMainController( );
      }
    } );
  }

}
