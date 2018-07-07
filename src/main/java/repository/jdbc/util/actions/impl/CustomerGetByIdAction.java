package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.actions.CustomerAction;

public class CustomerGetByIdAction extends CustomerAction {

	public CustomerGetByIdAction(long id) {
		this.customerId = id;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {
		dao.set(conn);
		Customer customer = dao.getById(customerId);
		return new Object[] { customer };
	}

}
