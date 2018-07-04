package repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import repository.CustomerRepository;
import repository.exception.DAOException;
import util.drm.ConnectionUtil;

public class JdbcCustomerRepositoryImplTest {

	Customer newCustomer;
	Customer existingCustomer;
	CustomerRepository dao;

	@Before
	public void setUp() {
		newCustomer = new Customer("TestName", "Ukraine", "Lvov");
		existingCustomer = new Customer("Cust1", "Ukraine", "Kiev");
		existingCustomer.setId(3L);
	}

	@Test
	public void testSave() throws SQLException {

		Long id = null;

		try (Connection conn = ConnectionUtil.getConnection();) {

			try {
				conn.setAutoCommit(false);

				dao = new JdbcCustomerRepositoryImpl();
				dao.set(conn);
				newCustomer = dao.save(newCustomer);

				ConnectionUtil.clearConnection(conn, null);

			} catch (SQLException | DAOException ex) {
				ConnectionUtil.clearConnection(conn, ex);
			}

		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		assertNotNull(newCustomer.getId());
	}

	@Test
	public void testUpdate() throws SQLException {

		long id = 0;

		try (Connection conn = ConnectionUtil.getConnection();) {

			try {

				conn.setAutoCommit(false);

				dao = new JdbcCustomerRepositoryImpl();
				dao.set(conn);
				id = dao.update(existingCustomer);

				ConnectionUtil.clearConnection(conn, null);

			} catch (SQLException | DAOException ex) {
				ConnectionUtil.clearConnection(conn, ex);
			}

		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		assertEquals(1, id);
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
