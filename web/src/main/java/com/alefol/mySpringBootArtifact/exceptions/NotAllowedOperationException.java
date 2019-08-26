package com.alefol.mySpringBootArtifact.exceptions;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 * @author romih
 */
public class NotAllowedOperationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     * @param message the message
     */
    public NotAllowedOperationException(final String message) {
        super(message);
    }
}
