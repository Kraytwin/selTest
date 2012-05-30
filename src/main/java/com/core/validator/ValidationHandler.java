package com.core.validator;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Set;

import com.rexsl.w3c.Defect;
import com.rexsl.w3c.ValidationResponse;

public class ValidationHandler implements ValidationResponse {

  private String response;

  public ValidationHandler( String response ) {
    this.response = response;
  }

  public Charset charset( ) {
    // TODO Auto-generated method stub
    return null;
  }

  public URI checkedBy( ) {
    // TODO Auto-generated method stub
    return null;
  }

  public String doctype( ) {
    // TODO Auto-generated method stub
    return null;
  }

  public Set<Defect> errors( ) {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean valid( ) {
    // TODO Auto-generated method stub
    return false;
  }

  public Set<Defect> warnings( ) {
    // TODO Auto-generated method stub
    return null;
  }

}
