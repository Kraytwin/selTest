package com.core.validator;

import com.rexsl.w3c.ValidationResponse;

public class TestValidator {

	public TestValidator( ) {
		
	}
	
	public static void main( String [] args ) {
		
		ValidationResponse response = new HTMLValidator("dfsdf").validate( "sdfsd" );
		assert response.valid( );
		
	}
	
}
