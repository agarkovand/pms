package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import app.exception.ApplicationException;
import model.Customer;

public class Application {

	public static Object[] parseLineToCustomer(String line)
			throws ApplicationException {

		if (line == null || line.isEmpty()) {
			throw new ApplicationException("Input line is null or empty.");
		}

		String[] tokens = line.split(",");

		if (tokens.length != 4) {
			throw new ApplicationException(String.format(
					"Input line should contain 4 tokens. It contains %s tokens instead.",
					tokens.length));
		}

		long id = Long.parseLong(tokens[0]);

		String name = tokens[1];
		String country = tokens[2];
		String city = tokens[3];

		Customer customer = new Customer(name, country, city);

		return new Object[] { id, customer };
	}

	public static Map<Long, Customer> collectCustomersFromCsvFile(
			String fileName) throws ApplicationException {

		Map<Long, Customer> customers = new HashMap<>();
		String line;
		Object[] item;

		try (InputStream is = Application.class.getResourceAsStream(fileName);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader bfr = new BufferedReader(isr);) {

			while ((line = bfr.readLine()) != null) {
				item = parseLineToCustomer(line);
				customers.put((Long) item[0], (Customer) item[1]);
			}

		} catch (FileNotFoundException e) {
			throw new ApplicationException("File not found: " + fileName);
		} catch (IOException e) {
			throw new ApplicationException("Problem reading file: " + fileName);
		}

		return customers;
	}
}
