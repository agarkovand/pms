package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.AbstractJdbcTestAction;
import repository.jdbc.util.CustomerAbstractJdbcTestAction;

public class CustomerSaveTestAction extends CustomerAbstractJdbcTestAction
		implements AbstractJdbcTestAction {

	public CustomerSaveTestAction(Customer newCustomer) {
		this.customer = newCustomer;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {
		dao.set(conn);
		customer = dao.save(customer);
		return new Object[0];
	}

}
