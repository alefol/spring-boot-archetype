package com.alefol.mySpringBootArtifact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 * @author romih
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     * @param message the message
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
