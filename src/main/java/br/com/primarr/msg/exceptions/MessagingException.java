package br.com.primarr.msg.exceptions;

public class MessagingException extends RuntimeException {

	public MessagingException() {
	}

	public MessagingException(String msg) {
		super(msg);
	}

	public MessagingException(Throwable rootCause) {
		super(rootCause);		
	}

	public MessagingException(String msg, Throwable rootCause) {
		super(msg, rootCause);
	}

}
