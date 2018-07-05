package repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import repository.jdbc.util.JdbcRepositoryTestUtil;
import repository.jdbc.util.impl.CustomerDeleteTestAction;
import repository.jdbc.util.impl.CustomerGetAllTestAction;
import repository.jdbc.util.impl.CustomerGetByIdTestAction;
import repository.jdbc.util.impl.CustomerSaveTestAction;
import repository.jdbc.util.impl.CustomerUpdateTestAction;

public class JdbcCustomerRepositoryImplTest {

	Customer newCustomer;
	Customer existingCustomer;
	long existingCustomerId;

	@Before
	public void setUp() {
		newCustomer = new Customer("TestName", "Ukraine", "Lvov");
		existingCustomer = new Customer("Cust1", "Ukraine", "Kiev");
		existingCustomer.setId(1L);
		existingCustomerId = 1L;
	}

	@Test
	public void testSave() throws SQLException {

		new JdbcRepositoryTestUtil()
				.performTest(new CustomerSaveTestAction(newCustomer));

		assertNotNull(newCustomer.getId());
	}

	@Test
	public void testUpdate() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil().performTest(
				new CustomerUpdateTestAction(existingCustomer));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testDelete() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil().performTest(
				new CustomerDeleteTestAction(existingCustomer));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		System.out.println(rowsAffected);

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testGetById() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil().performTest(
				new CustomerGetByIdTestAction(existingCustomerId));

		Customer customer = ((result.length == 0) ? null
				: (Customer) result[0]);

		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getCountry());
		assertNotNull(customer.getCity());

		System.out.println(customer);
	}

	@Test
	public void testGetAll() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil()
				.performTest(new CustomerGetAllTestAction());

		List<Customer> customers = ((result.length == 0) ? null
				: (List) result[0]);

		assertNotNull(customers);
		assertTrue(customers.size() > 0);

	}

}
