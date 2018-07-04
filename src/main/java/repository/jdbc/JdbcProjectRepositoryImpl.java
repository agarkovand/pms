package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	private static final String CUSTOMER_ID = "customer_id";
	private static final String NAME = "title";
	private static final String START = "project_start";
	private static final String PLAN_FINISH = "planned_finish";
	private static final String ACTUAL_FINISH = "actual_finish";

	/**
	 * INSERT INTO project
	 * (customer_id,title,project_start,planned_finish,actual_finish)
	 * VALUES (?,?,?,?,?);
	 */
	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?);",
			TABLE, CUSTOMER_ID, NAME, START, PLAN_FINISH,
			ACTUAL_FINISH);

	@Override
	public Project save(Project project, Long customer_id)
			throws DAOException {

		Long id = project.getId();

		if (id != null) {
			throw new DAOException(
					"Trying to persist existing customer: "
							+ project);
		}

		/**
		 * Connection is going to be closed in client code.
		 */
		try (PreparedStatement statement = conn.prepareStatement(
				insertSQL, Statement.RETURN_GENERATED_KEYS);) {

			statement.setLong(1, customer_id);
			statement.setString(2, project.getName());
			statement.setObject(3, project.getProject_start());
			statement.setObject(4, project.getPlanned_finish());
			statement.setObject(5, project.getActual_finish());

			statement.executeUpdate();

			ResultSet keyRS = statement.getGeneratedKeys();
			keyRS.next();
			id = (long) keyRS.getInt(1);
			project.setId(id);

		} catch (SQLException ex) {
			throw new DAOException(
					"Error creating project: " + project, ex);
		}

		return project;
	}

	/**
	 * DELETE FROM project WHERE customer_id=?;
	 */
	private static final String deleteProjectsSQL = String
			.format("DELETE FROM %s WHERE %s=?", TABLE, CUSTOMER_ID);

	@Override
	public int deleteByParent(Long strong_entity_id)
			throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Project t) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Project getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
