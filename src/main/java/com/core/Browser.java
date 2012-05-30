package com.core;

public class Browser {

  private String name, type, fileLocation, serverIP, screenshotDirectory;

  public Browser( String nameIn, String typeIn, String fileLocationIn, String serverIPIn, String screenshotDirectoryIn ) {
    serverIP = serverIPIn;
    name = nameIn;
    type = typeIn;
    fileLocation = fileLocationIn;
    screenshotDirectory = screenshotDirectoryIn;
  }

  public String getName( ) {
    return name;
  }

  public String getType( ) {
    return type;
  }

  public String getFileLocation( ) {
    return fileLocation;
  }

  public String getServerIP( ) {
    return serverIP;
  }

  public String getScreenshotDirectory( ) {
    return screenshotDirectory;
  }

}
