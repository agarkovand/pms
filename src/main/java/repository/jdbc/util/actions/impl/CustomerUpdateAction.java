package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.actions.CustomerAction;

public class CustomerUpdateAction extends CustomerAction {

	public CustomerUpdateAction(Customer existingCustomer) {
		this.customer = existingCustomer;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {
		dao.set(conn);
		int affectedRowsCount = dao.update(customer);
		return new Object[] { affectedRowsCount };
	}

}
