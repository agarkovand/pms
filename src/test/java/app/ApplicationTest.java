package app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import app.exception.ApplicationException;
import app.parsers.CustomerParser;
import model.Customer;

public class ApplicationTest {

	@Test
	public void allLinesFromFileConvertedToCustomersAndSavedToMap()
			throws ApplicationException {

		String fileName = "/data/customers_to_add_test.csv";

		Map<Long, Customer> customers = Application
				.collectEntitiesFromCsvFile(fileName,
						new CustomerParser());

		assertNotNull(customers);
		assertEquals(1, customers.size());

		Long[] expected_ids = new Long[] { 3L };

		assertArrayEquals(expected_ids, customers.keySet()
				.toArray(new Long[customers.size()]));

	}

}
