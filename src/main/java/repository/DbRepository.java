package repository;

import java.sql.Connection;
import java.util.List;

import repository.exception.DAOException;

public interface DbRepository<T> {

	public void set(Connection conn);

	public int update(T t) throws DAOException;

	public int delete(T t) throws DAOException;

	public T getById(long id);

	public List<T> getAll();
}
