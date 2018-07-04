package repository;

import repository.exception.DAOException;

public interface StrongEntityRepository<T> extends DbRepository<T> {

	public T save(T t) throws DAOException;

}
