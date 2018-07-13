package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Address;
import model.Customer;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtil
				.getSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction transaction = session.beginTransaction();

		Customer customer = createCustomer();
		Customer customer2 = createCustomer2();

		Address address = createAddress();

		customer.setAddress(address);
		customer2.setAddress(address);

		session.save(customer);
		session.save(customer2);
		transaction.commit();

		sessionfactory.close();

	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine("address line");
		address.setCity("City");
		address.setCountry("Country");
		address.setRegion("Region");
		address.setZipCode("99999");
		return address;
	}

	private static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setName("Client1");
		customer.setEmail("xxx@xxx.xxx");
		customer.setPhone("777888999");
		return customer;
	}

	private static Customer createCustomer2() {
		Customer customer = new Customer();
		customer.setName("Client1");
		customer.setEmail("yyy@yyy.yyy");
		customer.setPhone("888999000");
		return customer;
	}

}
