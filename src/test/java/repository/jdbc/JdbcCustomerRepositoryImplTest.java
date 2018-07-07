package repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import repository.jdbc.util.JdbcConnectionTestContextExecution;
import repository.jdbc.util.actions.impl.CustomerDeleteAction;
import repository.jdbc.util.actions.impl.CustomerGetAllAction;
import repository.jdbc.util.actions.impl.CustomerGetByIdAction;
import repository.jdbc.util.actions.impl.CustomerSaveAction;
import repository.jdbc.util.actions.impl.CustomerUpdateAction;

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

		new JdbcConnectionTestContextExecution()
				.performAction(new CustomerSaveAction(newCustomer));

		assertNotNull(newCustomer.getId());
	}

	@Test
	public void testUpdate() throws SQLException {

		Object[] result = new JdbcConnectionTestContextExecution()
				.performAction(new CustomerUpdateAction(
						existingCustomer));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testDelete() throws SQLException {

		Object[] result = new JdbcConnectionTestContextExecution()
				.performAction(new CustomerDeleteAction(
						existingCustomer));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		System.out.println(rowsAffected);

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testGetById() throws SQLException {

		Object[] result = new JdbcConnectionTestContextExecution()
				.performAction(new CustomerGetByIdAction(
						existingCustomerId));

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

		Object[] result = new JdbcConnectionTestContextExecution()
				.performAction(new CustomerGetAllAction());

		List<Customer> customers = ((result.length == 0) ? null
				: (List<Customer>) result[0]);

		assertNotNull(customers);
		assertTrue(customers.size() > 0);
		System.out.println(customers);

	}

}
