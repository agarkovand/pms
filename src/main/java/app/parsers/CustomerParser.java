package app.parsers;

import app.exception.ApplicationException;
import model.Customer;

public class CustomerParser extends AbstractEntityParser<Customer> {

	private static final int NUMBER_OF_TOKENS = 4;

	@Override
	public Object[] parse(String line) throws ApplicationException {

		checkNullOrEmpty(line);

		String[] tokens = line.split(",");

		checkNumberOfTokens(tokens.length, NUMBER_OF_TOKENS);

		long id = Long.parseLong(tokens[0]);

		String name = tokens[1];
		String country = tokens[2];
		String city = tokens[3];

		Customer customer = new Customer(name, country, city);

		return new Object[] { id, customer };
	}

}
