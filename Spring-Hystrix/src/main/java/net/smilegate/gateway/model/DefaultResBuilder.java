package net.smilegate.gateway.model;

/**
 * Builder 클래스
 * 표준
 * @author dsbae
 *
 * @param <T> 결합
 */
public class DefaultResBuilder<T> {
	
	// 재정의한 Response StatusCode
	private Integer statusCode;

	// Response Message
	private String responseMessage;

	// Response Data
	private T responseData;
	
	public DefaultResBuilder<T> setStatusCode(final Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	
	public DefaultResBuilder<T> setResponseMessage(final String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}
	
	public DefaultResBuilder<T> setResponseResult(final T responseData) {
		this.responseData = responseData;
		return this;
	}
	
	public DefaultRes<T> build() {
		return new DefaultRes<T>(this.statusCode, this.responseMessage, this.responseData);
	}
	
}

