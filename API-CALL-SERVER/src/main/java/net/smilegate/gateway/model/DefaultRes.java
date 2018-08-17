package net.smilegate.gateway.model;

/**
 * ResponseEntity
 * 표준
 * Builder 클래스 별도
 * @author dsbae
 *
 * @param <T> : Response Data와 결합
 */
public class DefaultRes<T> {
	
	//재정의한 Response StatusCode
	private int statusCode;
	
	//Response Message
	private String responseMessage;
	
	//Response Data
	private T responseData;

	public DefaultRes() {}
	
	public DefaultRes(final int statusCode, final String responseMessage, final T responseData) {
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responseData = responseData;
	}

	public DefaultRes(final int statusCode, final String responseMessage) {
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responseData = null;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public T getResponseData() {
		return responseData;
	}

}
