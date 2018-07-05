package repository.jdbc.util.impl;

import java.sql.Connection;
import java.util.List;

import model.Customer;
import repository.exception.DAOException;
import repository.jdbc.util.CustomerAbstractJdbcTestAction;

public class CustomerGetAllTestAction
		extends CustomerAbstractJdbcTestAction {

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		List<Customer> customers = dao.getAll();
		return new Object[] { customers };
	}

}
