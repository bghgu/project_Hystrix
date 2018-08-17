package net.smilegate.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.smilegate.gateway.model.DefaultRes;
import net.smilegate.gateway.model.User;
import net.smilegate.gateway.service.ApiCallService;
import net.smilegate.gateway.service.CRUDService;

/**
 * CRUDService Interface 구현체 non-hystrix
 * 
 * @author dsbae
 *
 */
@Service(value = "UserServiceImpl")
public class UserServiceImpl implements CRUDService<User> {

	private final ApiCallService<User> userApiCallService;
	
	@Autowired
	public UserServiceImpl(final ApiCallService<User> userApiCallService) {
		this.userApiCallService = userApiCallService;
	}

	/**
	 * User Resource Get
	 */
	@Override
	public DefaultRes<User> findOne(final int user_idx) {
		return userApiCallService.get(String.valueOf(user_idx));
	}

	/**
	 * User Resource Post
	 */
	@Override
	public DefaultRes<User> save(final User user) {
		return userApiCallService.post(user);
	}
	
	/**
	 * User Resource Put
	 */
	@Override
	public DefaultRes<User> update(final int user_idx, final User user) {
		return userApiCallService.put(String.valueOf(user_idx), user);
	}

	/**
	 * User Resource Delete
	 */
	@Override
	public DefaultRes<User> delete(final int user_idx) {
		return userApiCallService.delete(String.valueOf(user_idx));
	}

}
