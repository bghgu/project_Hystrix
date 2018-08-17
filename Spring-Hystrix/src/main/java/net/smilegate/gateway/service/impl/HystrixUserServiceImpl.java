package net.smilegate.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;
import net.smilegate.gateway.model.DefaultRes;
import net.smilegate.gateway.model.User;
import net.smilegate.gateway.service.ApiCallService;
import net.smilegate.gateway.service.CRUDService;
import net.smilegate.gateway.utils.InternalServerError;
import net.smilegate.gateway.utils.ResponseMessage;
import net.smilegate.gateway.utils.StatusCode;

/**
 * User Service Interface 구현체 with Hystrix
 * @author dsbae
 *
 */
@Slf4j
@Service(value = "HystrixUserServiceImpl")
public class HystrixUserServiceImpl implements CRUDService<User> {

	private static final DefaultRes<User> CIRCUIT_BREAKER = new DefaultRes<User>(StatusCode.SERVICE_UNAVAILABLE, ResponseMessage.CIRCUIT_BREAKER);

	private final ApiCallService<User> userApiCallService;

	@Autowired
	public HystrixUserServiceImpl(final ApiCallService<User> userApiCallService) {
		this.userApiCallService = userApiCallService;
	}

	/**
	 * Hystrix Thread Pool properties
	 * coreSize : Thread Pool 갯수
	 * maximumSize : 최대 Thread Pool 갯수
	 * allowMaximumSizeToDivergeFromCoreSize : 최대 큐 크기 속성 활성화
	 * maxQueueSize : 최대 Queue Size
	 * queueSizeRejectionThreshold : Queue Size
	 * thread.timeoutInMilliseconds : Thread TimeOut
	 * circuitBreaker.requestVolumeThreshold : Circuit Breaker Fallback Method Reject 동시 요청 갯수 제한
	 */
	
	@HystrixCommand(groupKey = "findOneFallback", commandKey = "findOneFallback", fallbackMethod = "findOneFallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "250"), @HystrixProperty(name = "maximumSize", value = "300"),
			@HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
			@HystrixProperty(name = "maxQueueSize", value = "987654321"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "300") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "300") })
	// @HystrixCommand(groupKey = "findOneFallback", commandKey = "findOneFallback",
	// fallbackMethod = "findOneFallback",
	// commandProperties = {
	// @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
	// @HystrixProperty(name =
	// "execution.isolation.semaphore.maxConcurrentRequests", value = "250"),
	// }
	// )
	/**
	 * User Resource Get
	 * 5030 Status Code Return시 Circuit Breaker 발동
	 */
	@Override
	public DefaultRes<User> findOne(final int user_idx) throws InternalServerError {
		final DefaultRes<User> res = userApiCallService.get(String.valueOf(user_idx));
		if (res.getStatusCode() == StatusCode.SERVICE_UNAVAILABLE) {
			//Circuit Breaker 강제 발생
			throw new InternalServerError("Remote Server Error");
		}
		return res;
	}

	@HystrixCommand(groupKey = "saveFallback", commandKey = "saveFallback", fallbackMethod = "saveFallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "220"), @HystrixProperty(name = "maximumSize", value = "250"),
			@HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
			@HystrixProperty(name = "maxQueueSize", value = "987654321"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "250") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "250") })
	/**
	 * User Resource Post
	 * 5030 Status Code Return시 Circuit Breaker 발동
	 */
	@Override
	public DefaultRes<User> save(final User user) throws InternalServerError {
		final DefaultRes<User> res = userApiCallService.post(user);
		if (res.getStatusCode() == StatusCode.SERVICE_UNAVAILABLE) {
			//Circuit Breaker 강제 발생
			throw new InternalServerError("Remote Server Error");
		}
		return res;
	}

	@HystrixCommand(groupKey = "updateFallback", commandKey = "updateFallback", fallbackMethod = "updateFallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "220"), @HystrixProperty(name = "maximumSize", value = "250"),
			@HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
			@HystrixProperty(name = "maxQueueSize", value = "987654321"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "250") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "250") })
	/**
	 * User Resource Put
	 * 5030 Status Code Return시 Circuit Breaker 발동
	 */
	@Override
	public DefaultRes<User> update(final int user_idx, final User user) throws InternalServerError {
		final DefaultRes<User> res = userApiCallService.put(String.valueOf(user_idx), user);
		if (res.getStatusCode() == StatusCode.SERVICE_UNAVAILABLE) {
			//Circuit Breaker 강제 발생
			throw new InternalServerError("Remote Server Error");
		}
		return res;
	}

	@HystrixCommand(groupKey = "deleteFallback", commandKey = "deleteFallback", fallbackMethod = "deleteFallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "220"), @HystrixProperty(name = "maximumSize", value = "250"),
			@HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
			@HystrixProperty(name = "maxQueueSize", value = "987654321"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "250") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "250") })
	/**
	 * User Resource Delete
	 * 5030 Status Code Return시 Circuit Breaker 발동
	 */
	@Override
	public DefaultRes<User> delete(final int user_idx) throws InternalServerError {
		final DefaultRes<User> res = userApiCallService.delete(String.valueOf(user_idx));
		if (res.getStatusCode() == StatusCode.SERVICE_UNAVAILABLE) {
			//Circuit Breaker 강제 발생
			throw new InternalServerError("Remote Server Error");
		}
		return res;
	}

	/**
	 * Circuit Breaker Fallback Method
	 */
	public DefaultRes<User> findOneFallback(final int user_idx) {
		log.info("get circuit breaker");
		return CIRCUIT_BREAKER;
	}

	public DefaultRes<User> saveFallback(final User user) {
		log.info("post circuit breaker");
		return CIRCUIT_BREAKER;
	}

	public DefaultRes<User> updateFallback(final int user_idx, final User user) {
		log.info("put circuit breaker");
		return CIRCUIT_BREAKER;
	}

	public DefaultRes<User> deleteFallback(final int user_idx) {
		log.info("delete circuit breaker");
		return CIRCUIT_BREAKER;
	}

}