package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Customer;
import model.Project;
import repository.CustomerRepository;
import repository.exception.DAOException;

public class JdbcCustomerRepositoryImpl
		implements CustomerRepository {

	/**
	 * Connection is going to be configured and set from client code.
	 */
	private Connection conn;

	@Override
	public void set(Connection conn) {
		this.conn = conn;
	}

	private static final String TABLE = "customer";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String COUNTRY = "country";
	private static final String CITY = "city";

	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s, %s, %s) VALUES (?,?,?);", TABLE,
			NAME, COUNTRY, CITY);
	private static final String updateSQL = String.format(
			"UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?", TABLE, NAME,
			COUNTRY, CITY, ID);

	@Override
	public Customer save(Customer customer) throws DAOException {

		Long id = customer.getId();

		if (id != null) {
			throw new DAOException(
					"Trying to persist existing customer: "
							+ customer);
		}

		/**
		 * Connection is going to be closed in client code.
		 */
		try (PreparedStatement statement = conn.prepareStatement(
				insertSQL, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, customer.getName());
			statement.setString(2, customer.getCountry());
			statement.setString(3, customer.getCity());

			statement.executeUpdate();

			ResultSet keyRS = statement.getGeneratedKeys();
			keyRS.next();
			id = (long) keyRS.getInt(1);
			customer.setId(id);

			saveProjects(customer);

		} catch (SQLException ex) {
			throw new DAOException(
					"Error saving customer: " + customer, ex);
		} catch (DAOException ex) {
			throw new DAOException(
					"Error saving projects of the customer: "
							+ customer,
					ex);
		}

		return customer;
	}

	protected void saveProjects(Customer customer)
			throws DAOException {

		List<Project> projects = customer.getProjects();

		if (projects.size() == 0) {
			return;
		}

		JdbcProjectRepositoryImpl dao = new JdbcProjectRepositoryImpl();
		dao.set(conn);
		long customer_id = customer.getId();

		for (Project project : projects) {
			dao.save(project, customer_id);
		}
	}

	@Override
	public int update(Customer t) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
