package repository.jdbc.util.actions;

import model.Customer;
import repository.CustomerRepository;
import repository.jdbc.JdbcCustomerRepositoryImpl;
import repository.jdbc.util.JdbcAction;

public abstract class CustomerAction implements JdbcAction {

	protected Customer customer;
	protected long customerId;
	protected CustomerRepository dao = new JdbcCustomerRepositoryImpl();

}