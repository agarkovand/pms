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

	/**
	 * customer table
	 */
	private static final String CUSTOMER_TABLE = "customer";
	private static final String ID_COLUMN = "id";
	private static final String NAME_COLUMN = "name";
	private static final String COUNTRY_COLUMN = "country";
	private static final String CITY_COLUMN = "city";

	/**
	 * INSERT INTO customer (name,country,city) VALUES (?,?,?);
	 */
	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s, %s, %s) VALUES (?,?,?);",
			CUSTOMER_TABLE, NAME_COLUMN, COUNTRY_COLUMN, CITY_COLUMN);

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

		if (projects == null || projects.size() == 0) {
			return;
		}

		JdbcProjectRepositoryImpl dao = new JdbcProjectRepositoryImpl();
		dao.set(conn);
		long customer_id = customer.getId();

		for (Project project : projects) {
			dao.save(project, customer_id);
		}
	}

	/**
	 * UPDATE customer SET name=?, country=?, city=? WHERE id=?;
	 */
	private static final String updateSQL = String.format(
			"UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?",
			CUSTOMER_TABLE, NAME_COLUMN, COUNTRY_COLUMN, CITY_COLUMN,
			ID_COLUMN);

	@Override
	public int update(Customer customer) throws DAOException {

		Long id = customer.getId();

		if (id == null) {
			throw new DAOException(
					"Trying to update new customer: " + customer);
		}

		int count = 0;

		try (PreparedStatement statement = conn
				.prepareStatement(updateSQL);) {

			statement.setString(1, customer.getName());
			statement.setString(2, customer.getCountry());
			statement.setString(3, customer.getCity());
			statement.setLong(4, id);

			count = statement.executeUpdate();

		} catch (SQLException ex) {
			throw new DAOException(
					"Error updating customer: " + customer, ex);
		}

		return count;
	}

	/**
	 * DELETE FROM customer WHERE id=?;
	 */
	private static final String deleteSQL = String.format(
			"DELETE FROM %s WHERE %s=?", CUSTOMER_TABLE, ID_COLUMN);

	@Override
	public int delete(Customer customer) throws DAOException {

		Long id = customer.getId();

		if (id == null) {
			throw new DAOException(
					"Trying to delete new customer: " + customer);
		}

		int count = 0;

		try (PreparedStatement statement = conn
				.prepareStatement(deleteSQL);) {

			statement.setLong(1, customer.getId());

			count = statement.executeUpdate();

		} catch (SQLException ex) {
			throw new DAOException("Error deleting customer with id: "
					+ customer.getId(), ex);
		}

		return count;
	}

	/**
	 * SELECT * FROM customer WHERE id = ?;
	 * 
	 * SELECT * FROM %s WHERE %s = ?;
	 */
	private static final String findByIdSQL = String.format(
			"SELECT * FROM %s WHERE %s = ?", CUSTOMER_TABLE,
			ID_COLUMN);

	@Override
	public Customer getById(long id) {

		System.out.println(findByIdSQL);
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
