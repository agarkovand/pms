package repository.jdbc.util.actions.impl;

import java.sql.Connection;
import java.util.List;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.actions.CustomerAction;

public class CustomerGetAllAction extends CustomerAction {

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		List<Customer> customers = dao.getAll();
		return new Object[] { customers };
	}

}
