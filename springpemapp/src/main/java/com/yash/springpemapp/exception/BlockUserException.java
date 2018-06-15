package com.yash.springpemapp.exception;

public class BlockUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlockUserException() {
	}
	
	public BlockUserException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
