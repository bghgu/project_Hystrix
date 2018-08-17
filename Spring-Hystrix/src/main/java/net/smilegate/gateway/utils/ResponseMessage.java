package net.smilegate.gateway.utils;

/**
 * Response Message 정의
 * @author dsbae
 *
 */
public class ResponseMessage {
	public static final String READ = "Success Find User";
	public static final String CREATED = "Success Save User";
	public static final String UPDATE = "Success Update User";
	public static final String DELETE = "Success Delete User";
	public static final String NOT_FOUND = "Not Find User";
	public static final String INTERNAL_SERVER_ERROR = "Fail";
	public static final String CIRCUIT_BREAKER = "Circuit Breaker Open";
}
