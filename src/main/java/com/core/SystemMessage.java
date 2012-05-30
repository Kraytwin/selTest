package com.core;


public class SystemMessage {

  public enum Type {
    CUST_ACTION, ERROR, GEN_ACTION, SEARCH, WAIT
  }
  private final Type TYPE;
  private final String INFO;
  
  public SystemMessage( Type typeIn, String infoIn ) {
    this.TYPE= typeIn;
    this.INFO = infoIn;
  }
  
  public Type getType( ) {
    return TYPE;
  }
  
  public String getInfo( ) {
    return INFO;
  }
  
}
