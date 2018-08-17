package net.smilegate.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smilegate.gateway.model.DefaultRes;
import net.smilegate.gateway.model.User;
import net.smilegate.gateway.service.CRUDService;
import net.smilegate.gateway.utils.ResponseMessage;
import net.smilegate.gateway.utils.StatusCode;

/**
 * UserService를 위한 Controller
 * @author dsbae
 *
 */

@RestController
@RequestMapping("users")
public class UserController {

	private static final DefaultRes<User> FAIL_DEFAULE_RES = new DefaultRes<User>(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);

	private final CRUDService<User> userService;

	/**
	 * Hystrix, non-Hystrix Service 사용하고 싶은거 사용 가능
	 * Hystrix 도입 여부 말고는 모두 동일한 기능 (CRUD)
	 */
	
	// Hystrix Service DI
	@Autowired
	public UserController(@Qualifier("HystrixUserServiceImpl") final CRUDService<User> userService) {
		this.userService = userService;
	}

	// Non-Hystrix Service DI
//		@Autowired
//		public UserController(@Qualifier("UserServiceImpl") final CRUDService<User> userService) {
//			this.userService = userService;
//		}
	
	/**
	 * User Resource 조회
	 * @param user_idx
	 * @return ResponseEntity
	 */
	@GetMapping("/{user_idx}")
	public ResponseEntity<DefaultRes<User>> getUsersByUserIdx(@PathVariable final int user_idx) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.findOne(user_idx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * User Resource 저장
	 * @param userReq
	 * @return ResponseEntity
	 */
	@PostMapping("")
	public ResponseEntity<DefaultRes<User>> postUser(@RequestBody final User userReq) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.save(userReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * User Resource 수정
	 * @param user_idx
	 * @param userReq
	 * @return ResponseEntity
	 */
	@PutMapping("/{user_idx}")
	public ResponseEntity<DefaultRes<User>> updateUserByUserIdx(@PathVariable final int user_idx, @RequestBody final User userReq) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.update(user_idx, userReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * User Resource 삭제
	 * @param user_idx
	 * @return ResponseEntity
	 */
	@DeleteMapping("/{user_idx}")
	public ResponseEntity<DefaultRes<User>> deleteUserByUserIdx(@PathVariable final int user_idx) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.delete(user_idx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
