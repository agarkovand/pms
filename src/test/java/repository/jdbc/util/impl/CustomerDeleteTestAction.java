package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.CustomerAbstractJdbcTestAction;

public class CustomerDeleteTestAction
		extends CustomerAbstractJdbcTestAction {

	public CustomerDeleteTestAction(Customer existingCustomer) {
		this.customer = existingCustomer;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.delete(customer);
		return new Object[] { affectedRowsCount };
	}

}
