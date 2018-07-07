package app.parsers;

import app.exception.ApplicationException;

public abstract class AbstractEntityParser<T> {

	abstract public Object[] parse(String line) throws ApplicationException;

	protected void checkNullOrEmpty(String line) throws ApplicationException {

		if (line == null || line.isEmpty()) {
			throw new ApplicationException("Input line is null or empty.");
		}
	}

	protected void checkNumberOfTokens(int actual, int expected)
			throws ApplicationException {

		if (actual != expected) {
			throw new ApplicationException(String.format(
					"Input line should contain %s tokens. It contains %s tokens instead.",
					expected, actual));
		}
	}

}
