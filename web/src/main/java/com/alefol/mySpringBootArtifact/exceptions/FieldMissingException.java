package com.alefol.mySpringBootArtifact.exceptions;

public class FieldMissingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2099597269677331463L;
	
   /**
    *
    * @param message the message
    */
   public FieldMissingException(final String message) {
       super(message);
   }

}
