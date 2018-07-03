package repository;

import java.util.List;

import repository.exception.DAOException;

public interface StrongEntityRepository<ID, T> extends DbRepository {

	public T save(T t) throws DAOException;

	public int update(T t) throws DAOException;

	public int delete(long id);

	public T getById(long id);

	public List<T> getAll();

}
