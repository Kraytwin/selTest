package com.core.validator;

public class UnknownValidatorException extends Exception {

	public UnknownValidatorException( ) {
		
	}
	
	public UnknownValidatorException( String validatorType ) {
		super( "Unrecognised validator " + validatorType );
	}

	
}
