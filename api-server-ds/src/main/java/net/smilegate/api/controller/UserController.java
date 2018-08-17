package net.smilegate.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import net.smilegate.api.domain.User;
import net.smilegate.api.model.DefaultRes;
import net.smilegate.api.service.CRUDService;
import net.smilegate.api.utils.ResponseMessage;
import net.smilegate.api.utils.StatusCode;

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
	
	@Autowired
	public UserController(final CRUDService<User> userService) {
		this.userService = userService;
	}
	
	/**
	 * User Resource 조회 Controller
	 * @param user_idx : User Resource index
	 * @return ResponseEntity
	 * 	성공시는 무조는 HttpStatus 200, 실패시는 500, DefaultRes안에서 ResultCode 재정의
	 *  조회 성공 : 2000, 조회 실패 : 4040, Server Error 5000
	 */
	@GetMapping("/{user_idx}")
	public ResponseEntity<DefaultRes<User>> getUsersByUserIdx(@PathVariable final int user_idx) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.findOne(user_idx), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * User Resource 저장 Controller
	 * @param userReq : User Resource
	 * @return ResponseEntity
	 * 	성공시는 무조는 HttpStatus 200, 실패시는 500, DefaultRes안에서 ResultCode 재정의
	 *  저장 성공 : 2010, Server Error 5000
	 */
	@PostMapping("")
	public ResponseEntity<DefaultRes<User>> postUser(@RequestBody final User userReq) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.save(userReq), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * User Resource 수정 Controller
	 * @param user_idx : User Resource index
	 * @param userReq : User Resource
	 * @return ResponseEntity
	 * 	성공시는 무조는 HttpStatus 200, 실패시는 500, DefaultRes안에서 ResultCode 재정의
	 *  수정 성공 : 2040, 수정 실패 : 4040, Server Error 5000
	 */
	@PutMapping("/{user_idx}")
	public ResponseEntity<DefaultRes<User>> updateUserByUserIdx(@PathVariable final int user_idx, @RequestBody final User userReq) {
		try {
			return new ResponseEntity<DefaultRes<User>>(userService.update(user_idx, userReq), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes<User>>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * User Resource 삭제 Controller
	 * @param user_idx : User Resource index
	 * @return ResponseEntity
	 * 	성공시는 무조는 HttpStatus 200, 실패시는 500, DefaultRes안에서 ResultCode 재정의
	 *  삭제 성공 : 2040, 삭제 실패 : 4040, Server Error 5000
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{user_idx}")
	public ResponseEntity<DefaultRes> deleteUserByUserIdx(@PathVariable final int user_idx) {
		try {
			return new ResponseEntity<DefaultRes>(userService.delete(user_idx), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DefaultRes>(FAIL_DEFAULE_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
