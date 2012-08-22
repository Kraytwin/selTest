package com.core;

import java.util.List;

public class NavigationUnitYAML {

  private String name;
  private String specialConditions;
  private List<MethodYAML> methods;

  public String getName( ) {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getSpecialConditions( ) {
    return specialConditions;
  }

  public void setSpecialConditions( String specialConditions ) {
    this.specialConditions = specialConditions;
  }

  public List<MethodYAML> getMethods( ) {
    return methods;
  }

  public void setMethods( List<MethodYAML> methods ) {
    this.methods = methods;
  }

}
