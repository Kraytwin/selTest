package com.core;

import java.util.ArrayList;

public class NavigationUnit {

  private String name;
  private ArrayList<SeleniumMethod> methods;

  // XXX need to get a selenium instance.
  public NavigationUnit( String nameIn, ArrayList<SeleniumMethod> methodsIn ) {
    this( );
    this.name = nameIn;
    this.methods = methodsIn;
  }

  public NavigationUnit( String nameIn ) {
    this( );
    this.name = nameIn;
    this.methods = new ArrayList<SeleniumMethod>( );
  }

  private NavigationUnit( ) {

  }

  public ArrayList<SeleniumMethod> getMethods( ) {
    return methods;
  }

  public void addMethod( SeleniumMethod methodIn ) {
    methods.add( methodIn );
  }

  public String getName( ) {
    return name;
  }

}
