package repository.jdbc.util;

import model.Customer;
import repository.jdbc.JdbcCustomerRepositoryImpl;

public abstract class CustomerAbstractJdbcTestAction
		implements AbstractJdbcTestAction {

	protected Customer customer;
	protected JdbcCustomerRepositoryImpl dao = new JdbcCustomerRepositoryImpl();

}
