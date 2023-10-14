package com.mandara.redditclone.exceptions;

public class SpringRedditException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpringRedditException(String exMessage, Exception ex) {
		super(exMessage, ex);
	}

	public SpringRedditException(String exMessage) {
		super(exMessage);
	}
}
