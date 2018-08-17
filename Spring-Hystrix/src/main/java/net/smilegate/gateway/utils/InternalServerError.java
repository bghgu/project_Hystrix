package net.smilegate.gateway.utils;

/*
 * Circuit Breaker를 강제로 발생시키기 위한 Exception
 */
public class InternalServerError extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InternalServerError(final String msg) {
		super(msg);
	}
}
