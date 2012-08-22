package com.core;

import java.util.List;

public class TestYAML {

  private String name;
  private String url;
  private List<NavigationUnitYAML> navigationUnits;

  public String getName( ) {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getUrl( ) {
    return url;
  }

  public void setUrl( String url ) {
    this.url = url;
  }

  public List<NavigationUnitYAML> getNavigationUnits( ) {
    return navigationUnits;
  }

  public void setNavigationUnits( List<NavigationUnitYAML> navigationUnits ) {
    this.navigationUnits = navigationUnits;
  }

}
