package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.AbstractJdbcTestAction;
import repository.jdbc.util.CustomerAbstractJdbcTestAction;

public class CustomerUpdateTestAction extends CustomerAbstractJdbcTestAction
		implements AbstractJdbcTestAction {

	public CustomerUpdateTestAction(Customer existingCustomer) {
		this.customer = existingCustomer;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {
		dao.set(conn);
		int id = dao.update(customer);
		return new Object[] { id };
	}

}
