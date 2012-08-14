package com.core;

import java.io.File;
import java.util.ArrayList;

public class TestHandler {

  private File directory;
  private ArrayList<File> testList;
  private String fileFormat;

  public TestHandler( File directoryIn, String fileFormatIn ) {
    this.directory = directoryIn;
    this.fileFormat = fileFormatIn;
    testList = new ArrayList<File>( );
    if ( directory.isDirectory( ) ) {
      this.fillTestList( );
    }
  }

  private void fillTestList( ) {
    testList.clear( );
    File[ ] allFiles = directory.listFiles( );

    if ( allFiles.length != 0 ) {
      for ( File file : allFiles ) {
        if ( file.isFile( ) && file.getName( ).endsWith( "." + fileFormat ) ) {
          testList.add( file );
        }
      }
    }
  }

  public ArrayList<File> getTestList( ) {
    return this.testList;
  }

  public File getDirectory( ) {
    return directory;
  }

  public boolean setTestDirectory( File directoryIn ) {
    if ( directoryIn.isDirectory( ) ) {
      this.directory = directoryIn;
      this.fillTestList( );
      return true;
    }
    return false;
  }

}
