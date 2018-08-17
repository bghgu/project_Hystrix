package net.smilegate.gateway.service;

import net.smilegate.gateway.model.DefaultRes;

/**
 * RestTemplate를 사용하기 위한 Interface
 * @author dsbae
 *
 * @param <T> 모듈화
 */
public interface ApiCallService<T> {
	DefaultRes<T> get(final String pathvariable);
	DefaultRes<T> post(final T t);
	DefaultRes<T> put(final String pathvariable, final T t);
	DefaultRes<T> delete(final String pathvariable);
}
