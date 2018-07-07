package service;

import java.sql.SQLException;
import java.util.List;

import model.Customer;
import repository.jdbc.util.ContextExecution;
import repository.jdbc.util.JdbcConnectionContextExecution;
import repository.jdbc.util.actions.impl.CustomerDeleteAction;
import repository.jdbc.util.actions.impl.CustomerGetAllAction;
import repository.jdbc.util.actions.impl.CustomerGetByIdAction;
import repository.jdbc.util.actions.impl.CustomerSaveAction;
import repository.jdbc.util.actions.impl.CustomerUpdateAction;
import service.exception.ServiceException;

public class CustomerService {

	public Customer getById(long id) throws ServiceException {

		ContextExecution executionInstance = new JdbcConnectionContextExecution();

		Object[] result = null;

		try {
			result = executionInstance
					.performAction(new CustomerGetByIdAction(id));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ServiceException(
					"Error getting customer with id: " + id, ex);
		}

		return ((result == null || result.length == 0)
				? new Customer()
				: (Customer) result[0]);

	}

	public Customer save(Customer customer) throws ServiceException {

		ContextExecution executionInstance = new JdbcConnectionContextExecution();

		Object[] result = null;

		try {
			result = executionInstance
					.performAction(new CustomerSaveAction(customer));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ServiceException(
					"Error saving customer: " + customer, ex);
		}

		return ((result == null || result.length == 0)
				? new Customer()
				: (Customer) result[0]);
	}

	public int update(Customer customer) throws ServiceException {

		ContextExecution executionInstance = new JdbcConnectionContextExecution();

		Object[] result = null;

		try {
			result = executionInstance.performAction(
					new CustomerUpdateAction(customer));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ServiceException(
					"Error saving customer: " + customer, ex);
		}

		return (result == null || result.length == 0) ? 0
				: (int) result[0];

	}

	public int delete(Customer customer) throws ServiceException {

		ContextExecution executionInstance = new JdbcConnectionContextExecution();

		Object[] result = null;

		try {
			result = executionInstance.performAction(
					new CustomerDeleteAction(customer));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ServiceException(
					"Error deleting customer: " + customer, ex);
		}

		return (result == null || result.length == 0) ? 0
				: (int) result[0];

	}

	public List<Customer> getAll() throws ServiceException {

		ContextExecution executionInstance = new JdbcConnectionContextExecution();

		Object[] result = null;

		try {
			result = executionInstance
					.performAction(new CustomerGetAllAction());
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ServiceException("Error getting all customers",
					ex);
		}

		return (result == null || result.length == 0) ? null
				: (List<Customer>) result[0];

	}

}
