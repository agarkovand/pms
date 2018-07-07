package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.actions.CustomerAction;

public class CustomerSaveAction extends CustomerAction {

	public CustomerSaveAction(Customer newCustomer) {
		this.customer = newCustomer;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {
		dao.set(conn);
		customer = dao.save(customer);
		return new Object[0];
	}

}
