package app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import app.exception.ApplicationException;
import model.Customer;

public class ApplicationTest {

	@Test
	public void shouldCreateValidCustomerObjectFromString()
			throws ApplicationException {

		String customerData = "3,Cust3,Ukraine,Odessa";

		Object[] item = Application.parseLineToCustomer(customerData);

		Customer customer = (Customer) item[1];

		assertNotNull(customer);
		assertEquals("Cust3", customer.getName());
		assertEquals("Ukraine", customer.getCountry());
		assertEquals("Odessa", customer.getCity());

	}

	@Test(expected = ApplicationException.class)
	public void ifLineIsNullOrEmptyShouldThrowApplicationException()
			throws ApplicationException {
		String customerData = "";
		Object[] item1 = Application.parseLineToCustomer(customerData);
		customerData = null;
		Object[] item2 = Application.parseLineToCustomer(customerData);
	}

	@Test(expected = ApplicationException.class)
	public void ifWrongNumberOfTokensInLineShouldThrowApplicationException()
			throws ApplicationException {
		String customerData = "3,Cust3,Ukraine,Odessa,Kiev";
		Object[] item1 = Application.parseLineToCustomer(customerData);
	}

	@Test
	public void allLinesFromFileConvertedToCustomersAndSavedToMap()
			throws ApplicationException {

		String fileName = "/data/customers_to_add_test.csv";

		Map<Long, Customer> customers = Application
				.collectCustomersFromCsvFile(fileName);

		assertNotNull(customers);
		assertEquals(4, customers.size());

		Long[] expected_ids = new Long[] { 3L, 4L, 5L, 6L };

		assertArrayEquals(expected_ids,
				customers.keySet().toArray(new Long[customers.size()]));

	}

}
