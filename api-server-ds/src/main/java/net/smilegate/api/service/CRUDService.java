package net.smilegate.api.service;

import net.smilegate.api.model.DefaultRes;

/**
 * CRUD Service Interface
 * CRUD 표준
 * @author dsbae
 * @param <T> : 다른 Domain과 결합
 */
public interface CRUDService<T> {	
	DefaultRes<T> findOne(final int id);
	DefaultRes<T> save(final T t);
	DefaultRes<T> update(final int id, T t);
	DefaultRes<T> delete(final int id);
}
