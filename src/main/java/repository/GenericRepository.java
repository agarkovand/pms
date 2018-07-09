package repository;

import java.util.List;

import repository.exception.DAOException;

public interface GenericRepository<T> {

	public T save(T t) throws DAOException;

	public int update(T t) throws DAOException;

	public int delete(T t) throws DAOException;

	public T getById(long id) throws DAOException;

	public List<T> getAll() throws DAOException;
}
