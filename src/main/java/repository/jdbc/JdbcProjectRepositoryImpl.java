package repository.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

	/**
	 * project table details
	 */
	private static final String PROJECT_TABLE = "project";
	private static final String ID_COLUMN = "id";
	private static final String CUSTOMER_ID_COLUMN = "customer_id";
	private static final String NAME_COLUMN = "title";
	private static final String START_COLUMN = "project_start";
	private static final String PLAN_FINISH_COLUMN = "planned_finish";
	private static final String ACTUAL_FINISH_COLUMN = "actual_finish";

	/**
	 * INSERT INTO project
	 * (customer_id,title,project_start,planned_finish,actual_finish)
	 * VALUES (?,?,?,?,?);
	 */
	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?);",
			PROJECT_TABLE, CUSTOMER_ID_COLUMN, NAME_COLUMN,
			START_COLUMN, PLAN_FINISH_COLUMN, ACTUAL_FINISH_COLUMN);

	@Override
	public Project save(Project project, Long customerId)
			throws DAOException {

		Long id = project.getId();

		if (id != null) {
			throw new DAOException(
					"Trying to persist existing project: " + project);
		}

		/**
		 * Connection is going to be closed in client code.
		 */
		try (PreparedStatement statement = conn.prepareStatement(
				insertSQL, Statement.RETURN_GENERATED_KEYS);) {

			statement.setLong(1, customerId);
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
	 * 
	 * DELETE FROM %s WHERE %s=?;
	 * 
	 */
	private static final String deleteByParentSQL = String.format(
			"DELETE FROM %s WHERE %s=?;", PROJECT_TABLE,
			CUSTOMER_ID_COLUMN);

	@Override
	public int deleteByParent(Long strongEntityId)
			throws DAOException {

		System.out.println(deleteByParentSQL);
		int count = 0;

		try (PreparedStatement ps = conn
				.prepareStatement(deleteByParentSQL);) {

			ps.setLong(1, strongEntityId);

			count = ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new DAOException("Error deleting projects for "
					+ CUSTOMER_ID_COLUMN + ": " + strongEntityId, ex);
		}

		return count;
	}

	/**
	 * UPDATE project SET title=?, project_start=?, planned_finish=?,
	 * actual_finish=? WHERE id=?;
	 * 
	 * UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?;
	 */
	private static final String updateSQL = String.format(
			"UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?",
			PROJECT_TABLE, NAME_COLUMN, START_COLUMN,
			PLAN_FINISH_COLUMN, ACTUAL_FINISH_COLUMN, ID_COLUMN);

	@Override
	public int update(Project project) throws DAOException {

		Long id = project.getId();

		if (id == null) {
			throw new DAOException(
					"Trying to update new project: " + project);
		}

		int count = 0;

		try (PreparedStatement ps = conn
				.prepareStatement(updateSQL);) {

			LocalDate projectStart = project.getProject_start();
			LocalDate plannedFinish = project.getPlanned_finish();
			LocalDate actualFinish = project.getActual_finish();

			ps.setString(1, project.getName());

			ps.setDate(2, projectStart == null ? null
					: Date.valueOf(projectStart));

			ps.setDate(3, plannedFinish == null ? null
					: Date.valueOf(plannedFinish));

			ps.setDate(4, actualFinish == null ? null
					: Date.valueOf(actualFinish));

			ps.setLong(5, project.getId());

			count = ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new DAOException(
					"Error updating project: " + project, ex);
		}

		return count;
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
