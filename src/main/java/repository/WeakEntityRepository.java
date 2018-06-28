package repository;

import java.util.List;

import model.Project;
import repository.exception.DAOException;

public interface WeakEntityRepository<ID, T> extends DbRepository {

	public T save(T t, ID strong_entity_id) throws DAOException;

	public int update(T t);

	public int delete(ID id);

	public Project getById(ID id);

	public List<T> getAll();
}
