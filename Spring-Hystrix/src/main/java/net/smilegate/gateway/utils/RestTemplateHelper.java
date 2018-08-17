package net.smilegate.gateway.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import net.smilegate.gateway.model.DefaultRes;

/**
 * RestTemplate Singleton
 * 
 * @author dsbae
 *
 */
public class RestTemplateHelper {

	// private HttpComponentsClientHttpRequestFactory factory;
	//
	// public RestTemplateHelper() {
	// this.factory = new HttpComponentsClientHttpRequestFactory();
	// factory.setReadTimeout(5000); // 읽기시간초과, ms
	// factory.setConnectTimeout(3000); // 연결시간초과, ms
	// HttpClient httpClient = HttpClientBuilder.create()
	// .setMaxConnTotal(100) // connection pool 적용
	// .setMaxConnPerRoute(5) // connection pool 적용
	// .build();
	// factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
	// }

	// @Autowired
	// public RestTemplateHelper(final RestTemplate restTemplate) {
	// log.info("DI RestTemplate");
	// RestTemplateHelper.restTemplate = restTemplate;
	// }

	private static final RestTemplate RESTTEMPLATE = new RestTemplate();

	/**
	 * GET API 호출
	 * 
	 * @param uri
	 * @return ResponseEntity
	 */
	public static <T> ResponseEntity<DefaultRes<T>> requestGet(final String uri) {
		return RESTTEMPLATE.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<DefaultRes<T>>() {
		});
	}

	/**
	 * POST API 호출
	 * 
	 * @param uri
	 * @param obj
	 * @return ResponseEntity
	 */
	public static <T> ResponseEntity<DefaultRes<T>> requestPost(final String uri, final T obj) {
		final HttpEntity<T> requestEntity = new HttpEntity<T>(obj, new HttpHeaders());
		return RESTTEMPLATE.exchange(uri, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<DefaultRes<T>>() {
				});
	}

	/**
	 * PUT API 호출
	 * 
	 * @param uri
	 * @param obj
	 * @return ResponseEntity
	 */
	public static <T> ResponseEntity<DefaultRes<T>> requestPut(final String uri, final T obj) {
		final HttpEntity<T> requestEntity = new HttpEntity<T>(obj, new HttpHeaders());
		return RESTTEMPLATE.exchange(uri, HttpMethod.PUT, requestEntity,
				new ParameterizedTypeReference<DefaultRes<T>>() {
				});
	}

	/**
	 * DELETE API 호출
	 * 
	 * @param uri
	 * @return ResponseEntity
	 */
	public static <T> ResponseEntity<DefaultRes<T>> requestDelete(final String uri) {
		return RESTTEMPLATE.exchange(uri, HttpMethod.DELETE, null, new ParameterizedTypeReference<DefaultRes<T>>() {
		});
	}
}
