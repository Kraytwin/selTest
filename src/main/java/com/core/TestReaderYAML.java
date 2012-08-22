package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class TestReaderYAML {

  public TestReaderYAML( File fileIn ) {

  }

  public static void main( String[ ] args ) {
    TestReaderYAML.buildTest( );
  }

  private static void buildTest( ) {
    /*
     * Constructor constructor = new Constructor( TestYAML.class );
     * TypeDescription testDescription = new TypeDescription( TestYAML.class );
     * testDescription.putListPropertyType( "navigation-unit", NavigationUnitYAML.class );
     * constructor.addTypeDescription( testDescription );
     */
    Yaml yaml = new Yaml( new Constructor( TestYAML.class ) );
    File file = new File( "/Users/stephenfallis/Desktop/test.yaml" );
    try {
      InputStream is = new FileInputStream( file );
      System.out.println( file.getName( ) );
      TestYAML test = ( TestYAML ) yaml.load( is );
      System.out.println( test.getName( ) );
    } catch ( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace( );
    }

  }

}
