package app.parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import app.exception.ApplicationException;
import model.Customer;

public class CustomerParserTest {

	CustomerParser testedObj;

	@Before
	public void setUp() {
		testedObj = new CustomerParser();
	}

	@Test(expected = ApplicationException.class)
	public void whenWrongNumberOfTokensInLineShouldThrowApplicationException()
			throws ApplicationException {

		String customerData = "3,Cust3,Ukraine,Odessa,Kiev";
		Object[] item1 = testedObj.parse(customerData);
	}

	@Test(expected = ApplicationException.class)
	public void whenLineIsNullOrEmptyShouldThrowApplicationException()
			throws ApplicationException {

		String customerData = "";
		Object[] item1 = testedObj.parse(customerData);
		customerData = null;
		Object[] item2 = testedObj.parse(customerData);
	}

	@Test
	public void correctLineShouldBeConvertedIntoCustomerObject()
			throws ApplicationException {

		String customerData = "3,Cust3,Ukraine,Odessa";

		Object[] item = testedObj.parse(customerData);

		Customer customer = (Customer) item[1];

		assertNotNull(customer);
		assertEquals("Cust3", customer.getName());
		assertEquals("Ukraine", customer.getCountry());
		assertEquals("Odessa", customer.getCity());

	}

}
