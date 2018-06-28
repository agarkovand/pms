package repository;

import java.sql.Connection;
import java.util.List;

import repository.exception.DAOException;

public interface GenericRepository<T, ID> {

	public T save(T t) throws DAOException;

	public int update(T t);

	public int delete(ID id);

	public T getById(ID id);

	public List<T> getAll();

	public void set(Connection conn);

}
