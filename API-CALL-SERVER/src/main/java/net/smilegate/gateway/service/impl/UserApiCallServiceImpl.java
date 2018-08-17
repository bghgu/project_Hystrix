package net.smilegate.gateway.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.smilegate.gateway.model.DefaultRes;
import net.smilegate.gateway.model.User;
import net.smilegate.gateway.service.ApiCallService;
import net.smilegate.gateway.utils.RestTemplateHelper;

/**
 * API CALL Service Interface 구현체
 * @author dsbae
 *
 */

@Service
public class UserApiCallServiceImpl implements ApiCallService<User>{

	@SuppressWarnings("unused")
	private final static String LOCALURI = "http://127.0.0.1:9090"; 
	private final static String SERVERURI = "http://10.250.64.162:8080/api";
	private final static String DOMAIN = "/users";

	/**
	 * User Get API CALL
	 */
	@Override
	public DefaultRes<User> get(final String pathvariable) {
		final String uri = SERVERURI + DOMAIN + "/" + pathvariable;
		ResponseEntity<DefaultRes<User>> responseEntity = RestTemplateHelper.requestGet(uri);
		return responseEntity.getBody();
	}

	/**
	 * User Post API CALL
	 */
	@Override
	public DefaultRes<User> post(final User user) {
		final String uri = SERVERURI + DOMAIN;
		ResponseEntity<DefaultRes<User>> responseEntity = RestTemplateHelper.requestPost(uri, user);
		return responseEntity.getBody();
	}

	/**
	 * User Put API CALL
	 */
	@Override
	public DefaultRes<User> put(final String pathvariable, final User user) {
		final String uri = SERVERURI + DOMAIN + "/" + pathvariable;
		ResponseEntity<DefaultRes<User>> responseEntity = RestTemplateHelper.requestPut(uri, user);
		return responseEntity.getBody();
	}

	/**
	 * User Delete API CALL
	 */
	@Override
	public DefaultRes<User> delete(final String pathvariable) {
		final String uri = SERVERURI + DOMAIN + "/" + pathvariable;
		ResponseEntity<DefaultRes<User>> responseEntity = RestTemplateHelper.requestDelete(uri);
		return responseEntity.getBody();
	}

}
