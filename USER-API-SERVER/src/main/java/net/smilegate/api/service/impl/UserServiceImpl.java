package net.smilegate.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.smilegate.api.domain.User;
import net.smilegate.api.model.DefaultRes;
import net.smilegate.api.model.DefaultResBuilder;
import net.smilegate.api.repository.UserRepository;
import net.smilegate.api.service.CRUDService;
import net.smilegate.api.utils.ResponseMessage;
import net.smilegate.api.utils.StatusCode;

/**
 * CRUD Interface 구현체
 * 
 * @author dsbae
 *
 */
@Service
public class UserServiceImpl implements CRUDService<User> {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * User Resource 조회
	 */
	@Override
	public DefaultRes<User> findOne(final int user_idx) {
		final Optional<User> user = userRepository.findById(user_idx);
		DefaultRes<User> response = null;
		if (user.isPresent()) {
			response = new DefaultResBuilder<User>().setStatusCode(StatusCode.OK)
					.setResponseMessage(ResponseMessage.READ).setResponseResult(user.get()).build();
		}
		response = new DefaultResBuilder<User>().setStatusCode(StatusCode.NOT_FOUND)
				.setResponseMessage(ResponseMessage.NOT_FOUND).build();
		return response;
	}

	/**
	 * User Resource 저장
	 */
	@Override
	public DefaultRes<User> save(final User user) {
		DefaultRes<User> response = new DefaultResBuilder<User>().setStatusCode(StatusCode.CREATED)
				.setResponseMessage(ResponseMessage.CREATED).setResponseResult(userRepository.save(user)).build();
		return response;
	}

	/**
	 * User Resource 수정 findOne을 먼저 한 다음, 변경 된 값만 수정
	 */
	@Override
	public DefaultRes<User> update(final int user_idx, final User user) {
		final Optional<User> temp = userRepository.findById(user_idx);
		DefaultRes<User> response = null;
		if (temp.isPresent()) {
			user.setName(user.getName() != null ? user.getName() : temp.get().getName());
			user.setEmail(user.getEmail() != null ? user.getEmail() : temp.get().getEmail());
			user.setuser_idx(user_idx);
			response = new DefaultResBuilder<User>().setStatusCode(StatusCode.NO_CONTENT)
					.setResponseMessage(ResponseMessage.UPDATE).setResponseResult(userRepository.save(user)).build();
			return response;
		}
		response = new DefaultResBuilder<User>().setStatusCode(StatusCode.NOT_FOUND)
				.setResponseMessage(ResponseMessage.NOT_FOUND).build();
		return response;
	}

	/**
	 * User Resource 삭제 findeOne을 먼저 한 다음, 존재할 때만 삭제
	 */
	@Override
	public DefaultRes<User> delete(final int user_idx) {
		final Optional<User> temp = userRepository.findById(user_idx);
		DefaultRes<User> response = null;
		if (temp.isPresent()) {
			userRepository.deleteByUserIdx(user_idx);
			response = new DefaultResBuilder<User>().setStatusCode(StatusCode.NO_CONTENT)
					.setResponseMessage(ResponseMessage.DELETE).build();
		}
		response = new DefaultResBuilder<User>().setStatusCode(StatusCode.NOT_FOUND)
				.setResponseMessage(ResponseMessage.NOT_FOUND).build();
		return response;
	}

}
