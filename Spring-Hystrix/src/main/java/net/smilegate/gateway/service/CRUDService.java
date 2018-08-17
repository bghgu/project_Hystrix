package net.smilegate.gateway.service;

import net.smilegate.gateway.model.DefaultRes;
import net.smilegate.gateway.utils.InternalServerError;

/**
 * CRUD Service Interface
 * CRUD 표준
 * @author dsbae
 * @param <T> : 다른 Domain과 결합
 */
public interface CRUDService<T> {
	DefaultRes<T> findOne(final int id) throws InternalServerError ;
	DefaultRes<T> save (final T t) throws InternalServerError ;
	DefaultRes<T> update (final int id, T t) throws InternalServerError ;
	DefaultRes<T> delete (final int id) throws InternalServerError ;
}


