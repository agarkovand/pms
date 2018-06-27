package repository.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import repository.CustomerRepository;
import repository.DAOException;
import util.drm.ConnectionUtil;

public class JdbcCustomerRepositoryImplTest {

	Customer newCustomer;
	Customer existingCustomer;
	CustomerRepository dao;

	@Before
	public void setUp() {
		newCustomer = new Customer("TestName", "Ukraine", "Lvov");
		existingCustomer = new Customer("Cust1", "Ukraine", "Kiev");
		existingCustomer.setId(1L);
	}

	@Test
	public void testSave() throws SQLException {

		Long id = null;

		try (Connection conn = ConnectionUtil.getConnection();) {

			try {
				conn.setAutoCommit(false);

				dao = new JdbcCustomerRepositoryImpl(conn);
				newCustomer = dao.save(newCustomer);

				postProcessConnection(conn, null);

			} catch (SQLException ex) {
				postProcessConnection(conn, ex);
			} catch (DAOException ex) {
				postProcessConnection(conn, ex);
			}
		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		assertNotNull(newCustomer.getId());
	}

	private void postProcessConnection(Connection conn, Exception ex)
			throws SQLException {
		conn.rollback();
		conn.setAutoCommit(true);
		if (ex != null) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
