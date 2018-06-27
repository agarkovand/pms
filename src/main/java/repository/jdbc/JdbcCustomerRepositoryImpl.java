package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Customer;
import repository.CustomerRepository;
import repository.DAOException;

public class JdbcCustomerRepositoryImpl implements CustomerRepository {

	/**
	 * Connection is going to be configured and set from client code.
	 */
	private Connection conn;

	public JdbcCustomerRepositoryImpl(Connection conn) {
		this.conn = conn;
	}

	private static final String table = "customer";
	private static final String id = "id";
	private static final String name = "name";
	private static final String country = "country";
	private static final String city = "city";

	private static final String insertSQL = String.format(
			"INSERT INTO %s (%s, %s, %s) VALUES (?,?,?);", table, name, country,
			city);
	private static final String updateSQL = String.format(
			"UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?", table, name, country,
			city, id);

	@Override
	public Customer save(Customer customer) throws DAOException {

		Long id = customer.getId();

		if (id != null) {
			throw new DAOException(
					"Trying to persist existing customer: " + customer);
		}

		/**
		 * Connection is going to be closed in client code.
		 */
		try (PreparedStatement statement = conn.prepareStatement(insertSQL,
				Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, customer.getName());
			statement.setString(2, customer.getCountry());
			statement.setString(3, customer.getCity());

			statement.executeUpdate();

			ResultSet keyRS = statement.getGeneratedKeys();
			keyRS.next();
			id = (long) keyRS.getInt(1);
			customer.setId(id);

		} catch (SQLException ex) {
			throw new DAOException("Error saving customer: " + customer, ex);
		}

		return customer;
	}

	@Override
	public int update(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
