/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Stephen Fallis
 */
public class SelMain extends javax.swing.JFrame {

  /**
   * Creates new form NewJFrame
   */
  public SelMain( ) {
    initComponents( );
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents( ) {

    testLabel = new javax.swing.JLabel( );
    testPreviewLabel = new javax.swing.JLabel( );
    siteLabel = new javax.swing.JLabel( );
    browserLabel = new javax.swing.JLabel( );
    jScrollPane1 = new javax.swing.JScrollPane( );
    testList = new javax.swing.JList( );
    jScrollPane2 = new javax.swing.JScrollPane( );
    testPreviewArea = new javax.swing.JTextArea( );
    jScrollPane3 = new javax.swing.JScrollPane( );
    siteList = new javax.swing.JList( );
    jScrollPane4 = new javax.swing.JScrollPane( );
    browserList = new javax.swing.JList( );
    jScrollPane5 = new javax.swing.JScrollPane( );
    consoleTextField = new javax.swing.JTextArea( );
    editTestButton = new javax.swing.JButton( );
    specialCommandLabel = new javax.swing.JLabel( );
    screenshotCheckbox = new javax.swing.JCheckBox( );
    validateHTMLCheckbox = new javax.swing.JCheckBox( );
    validateCSSCheckbox = new javax.swing.JCheckBox( );
    selStatusLabel = new javax.swing.JLabel( );
    startTestButton = new javax.swing.JButton( );
    selStartButton = new javax.swing.JToggleButton( );
    menuBar = new javax.swing.JMenuBar( );
    fileMenu = new javax.swing.JMenu( );
    testDirMenuItem = new javax.swing.JMenuItem( );
    jSeparator2 = new javax.swing.JPopupMenu.Separator( );
    quitMenuItem = new javax.swing.JMenuItem( );
    toolMenu = new javax.swing.JMenu( );
    setSiteFileMenuItem = new javax.swing.JMenuItem( );
    setTestDirMenuItem = new javax.swing.JMenuItem( );
    setBrowserFileMenuItem = new javax.swing.JMenuItem( );
    jSeparator1 = new javax.swing.JPopupMenu.Separator( );
    specialCommandsPropertiesMenuItem = new javax.swing.JMenuItem( );
    selPropertiesMenuItem = new javax.swing.JMenuItem( );
    systemPropertiesMenuItem = new javax.swing.JMenuItem( );
    viewMenu = new javax.swing.JMenu( );
    openSpecialDirMenuItem = new javax.swing.JMenuItem( );
    openSelLogMenuItem = new javax.swing.JMenuItem( );
    testMenu = new javax.swing.JMenu( );
    addPasswordMenuItem = new javax.swing.JMenuItem( );
    editTestMenuItem = new javax.swing.JMenuItem( );

    setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );

    testList.setModel( new javax.swing.AbstractListModel( ) {

      String[ ] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

      public int getSize( ) {
        return strings.length;
      }

      public Object getElementAt( int i ) {
        return strings[ i ];
      }
    } );
    jScrollPane1.setViewportView( testList );

    testPreviewArea.setColumns( 20 );
    testPreviewArea.setRows( 5 );
    jScrollPane2.setViewportView( testPreviewArea );

    siteList.setModel( new javax.swing.AbstractListModel( ) {

      String[ ] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

      public int getSize( ) {
        return strings.length;
      }

      public Object getElementAt( int i ) {
        return strings[ i ];
      }
    } );
    jScrollPane3.setViewportView( siteList );

    browserList.setModel( new javax.swing.AbstractListModel( ) {

      String[ ] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

      public int getSize( ) {
        return strings.length;
      }

      public Object getElementAt( int i ) {
        return strings[ i ];
      }
    } );
    jScrollPane4.setViewportView( browserList );

    consoleTextField.setColumns( 20 );
    consoleTextField.setRows( 5 );
    jScrollPane5.setViewportView( consoleTextField );

    fileMenu.add( testDirMenuItem );
    fileMenu.add( jSeparator2 );
    fileMenu.add( quitMenuItem );
    menuBar.add( fileMenu );
    toolMenu.add( setSiteFileMenuItem );
    toolMenu.add( setTestDirMenuItem );
    toolMenu.add( setBrowserFileMenuItem );
    toolMenu.add( jSeparator1 );
    toolMenu.add( specialCommandsPropertiesMenuItem );
    toolMenu.add( selPropertiesMenuItem );
    toolMenu.add( systemPropertiesMenuItem );
    menuBar.add( toolMenu );
    viewMenu.add( openSpecialDirMenuItem );
    viewMenu.add( openSelLogMenuItem );
    menuBar.add( viewMenu );
    testMenu.add( addPasswordMenuItem );
    testMenu.add( editTestMenuItem );
    menuBar.add( testMenu );
    setJMenuBar( menuBar );

    testLabel.setText( "Tests" );
    testPreviewLabel.setText( "Test Preview" );
    siteLabel.setText( "Sites" );
    browserLabel.setText( "Browsers" );
    editTestButton.setText( "Edit Test" );
    specialCommandLabel.setText( "Special Commands" );
    screenshotCheckbox.setText( "Screenshots" );
    validateHTMLCheckbox.setText( "Validate HTML" );
    validateCSSCheckbox.setText( "Validate CSS" );
    selStatusLabel.setText( "Selenium RC Status + Site" );
    startTestButton.setText( "Start Test" );
    selStartButton.setText( "Selenium Start" );
    fileMenu.setText( "File" );
    testDirMenuItem.setText( "Open Test Directory" );
    quitMenuItem.setText( "Quit" );
    toolMenu.setText( "Tools" );
    setSiteFileMenuItem.setText( "Set Site File" );
    setTestDirMenuItem.setText( "Set Test Directory" );
    setBrowserFileMenuItem.setText( "Set Browser File" );
    specialCommandsPropertiesMenuItem.setText( "Special Command Properties" );
    selPropertiesMenuItem.setText( "Selenium Properties" );
    systemPropertiesMenuItem.setText( "System Properties" );
    viewMenu.setText( "View" );
    openSpecialDirMenuItem.setText( "Open Special Directory" );
    openSelLogMenuItem.setText( "View Selenium Directory" );
    testMenu.setText( "Test" );
    addPasswordMenuItem.setText( "Add Password" );
    editTestMenuItem.setText( "Edit Test" );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
    getContentPane( ).setLayout( layout );
    layout
        .setHorizontalGroup( layout
            .createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup( )
                    .addGap( 64, 64, 64 )
                    .addComponent( testLabel )
                    .addGap( 186, 186, 186 )
                    .addComponent( testPreviewLabel )
                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( siteLabel )
                    .addGap( 99, 99, 99 ) )
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup( )
                    .addContainerGap( )
                    .addGroup(
                        layout
                            .createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING )
                            .addGroup(
                                layout
                                    .createSequentialGroup( )
                                    .addGroup(
                                        layout
                                            .createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING )
                                            .addComponent( jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING )
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup( )
                                                    .addComponent( jScrollPane1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE )
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING )
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup( )
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                                    .addComponent( jScrollPane2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 289,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                                            .addGroup(
                                                                layout.createSequentialGroup( ).addGap( 121, 121, 121 )
                                                                    .addComponent( editTestButton ) ) ) ) )
                                    .addGroup(
                                        layout
                                            .createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING )
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup( )
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false )
                                                            .addComponent( jScrollPane4,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 185,
                                                                Short.MAX_VALUE ).addComponent( jScrollPane3 ) ) )
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                layout
                                                    .createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING )
                                                    .addGroup(
                                                        layout
                                                            .createSequentialGroup( )
                                                            .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                            .addComponent( startTestButton ) )
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING )
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                layout.createSequentialGroup( ).addGap( 73, 73, 73 )
                                                                    .addComponent( browserLabel ) )
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                layout.createSequentialGroup( ).addGap( 47, 47, 47 )
                                                                    .addComponent( specialCommandLabel ) )
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                layout
                                                                    .createSequentialGroup( )
                                                                    .addGap( 18, 18, 18 )
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING )
                                                                            .addComponent( validateHTMLCheckbox )
                                                                            .addComponent( screenshotCheckbox )
                                                                            .addComponent( validateCSSCheckbox ) ) ) ) ) )
                                    .addContainerGap( ) )
                            .addGroup(
                                layout
                                    .createSequentialGroup( )
                                    .addGap( 0, 0, Short.MAX_VALUE )
                                    .addComponent( selStartButton )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
                                    .addComponent( selStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233,
                                        javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 37, 37, 37 ) ) ) ) );
    layout
        .setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(
                layout
                    .createSequentialGroup( )
                    .addContainerGap( )
                    .addGroup(
                        layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                            .addComponent( testLabel ).addComponent( testPreviewLabel ).addComponent( siteLabel ) )
                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                    .addGroup(
                        layout
                            .createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                            .addGroup(
                                layout
                                    .createSequentialGroup( )
                                    .addComponent( jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                        javax.swing.GroupLayout.PREFERRED_SIZE )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                    .addComponent( browserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14,
                                        javax.swing.GroupLayout.PREFERRED_SIZE )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                    .addComponent( jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 159,
                                        Short.MAX_VALUE ) ).addComponent( jScrollPane2 ).addComponent( jScrollPane1 ) )
                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                    .addComponent( editTestButton )
                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                    .addGroup(
                        layout
                            .createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false )
                            .addGroup(
                                layout
                                    .createSequentialGroup( )
                                    .addGap( 17, 17, 17 )
                                    .addComponent( specialCommandLabel )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
                                    .addComponent( screenshotCheckbox )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                    .addComponent( validateHTMLCheckbox )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                    .addComponent( validateCSSCheckbox )
                                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
                                    .addComponent( startTestButton ) )
                            .addComponent( jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
                                javax.swing.GroupLayout.PREFERRED_SIZE ) )
                    .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                    .addGroup(
                        layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                            .addComponent( selStatusLabel ).addComponent( selStartButton ) ).addContainerGap( ) ) );

    pack( );
  }// </editor-fold>//GEN-END:initComponents

  public void addActionListeners( ActionListener act ) {
    editTestButton.addActionListener( act );
    screenshotCheckbox.addActionListener( act );
    validateCSSCheckbox.addActionListener( act );
    validateHTMLCheckbox.addActionListener( act );
    testDirMenuItem.addActionListener( act );
    quitMenuItem.addActionListener( act );
    setTestDirMenuItem.addActionListener( act );
    setBrowserFileMenuItem.addActionListener( act );
    specialCommandsPropertiesMenuItem.addActionListener( act );
    selPropertiesMenuItem.addActionListener( act );
    systemPropertiesMenuItem.addActionListener( act );
    openSpecialDirMenuItem.addActionListener( act );
    openSelLogMenuItem.addActionListener( act );
    addPasswordMenuItem.addActionListener( act );
    editTestMenuItem.addActionListener( act );

  }

  public void addListSelectionListeners( ListSelectionListener lis ) {
    browserList.addListSelectionListener( lis );
    siteList.addListSelectionListener( lis );
    testList.addListSelectionListener( lis );
  }

  public Component getComponent( String name ) {
    Component[ ] compList = this.getComponents( );

    for ( Component comp : compList ) {
      if ( comp.getName( ).equals( name ) ) {
        return comp;
      }
    }

    return null;
  }

  public void quit( ) {
    this.dispose( );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem addPasswordMenuItem;
  private javax.swing.JLabel browserLabel;
  private javax.swing.JList browserList;
  private javax.swing.JTextArea consoleTextField;
  private javax.swing.JButton editTestButton;
  private javax.swing.JMenuItem editTestMenuItem;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem openSelLogMenuItem;
  private javax.swing.JMenuItem openSpecialDirMenuItem;
  private javax.swing.JMenuItem quitMenuItem;
  private javax.swing.JCheckBox screenshotCheckbox;
  private javax.swing.JMenuItem selPropertiesMenuItem;
  private javax.swing.JToggleButton selStartButton;
  private javax.swing.JLabel selStatusLabel;
  private javax.swing.JMenuItem setBrowserFileMenuItem;
  private javax.swing.JMenuItem setSiteFileMenuItem;
  private javax.swing.JMenuItem setTestDirMenuItem;
  private javax.swing.JLabel siteLabel;
  private javax.swing.JList siteList;
  private javax.swing.JLabel specialCommandLabel;
  private javax.swing.JMenuItem specialCommandsPropertiesMenuItem;
  private javax.swing.JButton startTestButton;
  private javax.swing.JMenuItem systemPropertiesMenuItem;
  private javax.swing.JMenuItem testDirMenuItem;
  private javax.swing.JLabel testLabel;
  private javax.swing.JList testList;
  private javax.swing.JMenu testMenu;
  private javax.swing.JTextArea testPreviewArea;
  private javax.swing.JLabel testPreviewLabel;
  private javax.swing.JMenu toolMenu;
  private javax.swing.JCheckBox validateCSSCheckbox;
  private javax.swing.JCheckBox validateHTMLCheckbox;
  private javax.swing.JMenu viewMenu;
  // End of variables declaration//GEN-END:variables
}
