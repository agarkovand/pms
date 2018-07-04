package repository;

import repository.exception.DAOException;

public interface WeakEntityRepository<T, ID> extends DbRepository<T> {

	public T save(T t, ID strong_entity_id) throws DAOException;

	public int deleteByParent(ID strong_entity_id)
			throws DAOException;

}
