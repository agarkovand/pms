package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.CustomerAbstractJdbcTestAction;

public class CustomerGetByIdTestAction
		extends CustomerAbstractJdbcTestAction {

	public CustomerGetByIdTestAction(long existingCustomerId) {
		this.customerId = existingCustomerId;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		Customer customer = dao.getById(customerId);
		return new Object[] { customer };
	}

}
