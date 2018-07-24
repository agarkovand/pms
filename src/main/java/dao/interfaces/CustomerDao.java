package dao.interfaces;

import java.util.List;

import model.Customer;

public interface CustomerDao extends Dao<Customer, Long> {

	Customer fetchEmails(Customer customer);

	List<Customer> findCustomersByCountry(String country);

}
