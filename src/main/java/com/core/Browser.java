package com.core;

public class Browser {

  private String name, type, fileLocation, serverIP, specialDirectory;

  public Browser( String nameIn, String typeIn, String fileLocationIn, String serverIPIn, String specialDirectoryIn ) {
    serverIP = serverIPIn;
    name = nameIn;
    type = typeIn;
    fileLocation = fileLocationIn;
    specialDirectory = specialDirectoryIn;
  }

  public void setName( String nameIn ) {
    this.name = nameIn;
  }

  public String getName( ) {
    return name;
  }

  public void setType( String typeIn ) {
    this.type = typeIn;
  }

  public String getType( ) {
    return type;
  }

  public void setFileLocation( String fileLocationIn ) {
    this.fileLocation = fileLocationIn;
  }

  public String getFileLocation( ) {
    return fileLocation;
  }

  public void setServerIP( String serverIPIn ) {
    this.serverIP = serverIPIn;
  }

  public String getServerIP( ) {
    return serverIP;
  }

  public void setSpecialDirectory( String specialDirectoryIn ) {
    this.specialDirectory = specialDirectoryIn;
  }

  public String getSpecialDirectory( ) {
    return specialDirectory;
  }

}
