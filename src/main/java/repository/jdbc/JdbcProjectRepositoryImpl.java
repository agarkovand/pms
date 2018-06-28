package repository.jdbc;

import java.sql.Connection;
import java.util.List;

import model.Project;
import repository.ProjectRepository;
import repository.exception.DAOException;

public class JdbcProjectRepositoryImpl implements ProjectRepository {

	/**
	 * Connection is going to be configured and set from client code.
	 */
	private Connection conn;

	@Override
	public void set(Connection conn) {
		this.conn = conn;
	}

	private static final String TABLE = "project";
	private static final String ID = "id";
	private static final String NAME = "title";
	private static final String START = "project_start";
	private static final String PLAN_FINISH = "planned_finish";
	private static final String ACTUAL_FINISH = "actual_finish";

	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s, %s, %s) VALUES (?,?,?);", TABLE, NAME, START,
			PLAN_FINISH);
	private static final String updateSQL = String.format(
			"UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?", TABLE, NAME, START,
			PLAN_FINISH, ID);

	@Override
	public Project save(Project t, Long customer_id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Project t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Project getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
