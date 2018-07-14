package app;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Address;
import model.Customer;
import model.Email;
import model.Project;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtil
				.getSessionFactory();

		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = createCustomer();
		Customer customer2 = createCustomer2();

		session.save(customer);
		session.save(customer2);

		transaction.commit();
		sessionfactory.close();

	}

	private static Email createEmail() {
		Email email = new Email();
		email.setEmail("xxx@xxx.xx");
		email.setKind("home");
		return email;
	}

	private static Email createEmail2() {
		Email email = new Email();
		email.setEmail("yyy@yyy.yy");
		email.setKind("work");
		return email;
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

		customer.getPhones().add("777888999");
		customer.getPhones().add("666888999");

		Address address = createAddress();

		Email email = createEmail();
		Email email2 = createEmail2();

		customer.setAddress(address);

		customer.getEmails().add(email);
		customer.getEmails().add(email2);

		Project project1 = createProject("Project 3");
		Project project2 = createProject("Project 4");

		customer.getProjects().add(project1);
		customer.getProjects().add(project2);

		return customer;
	}

	private static Project createProject(String name) {

		Project project = new Project();

		project.setName(name);
		project.setTotalBudget(new BigDecimal(2500));
		project.setStartDate(LocalDate.now());
		project.setDeliveryDate(LocalDate.of(2018, 12, 31));

		return project;
	}

	private static Customer createCustomer2() {

		Customer customer = new Customer();

		customer.setName("Client2");

		customer.getPhones().add("888999000");
		customer.getPhones().add("777999000");
		customer.getPhones().add("666999000");

		Address address = createAddress();

		Email email = createEmail();
		Email email2 = createEmail2();

		customer.setAddress(address);

		customer.getEmails().add(email);
		customer.getEmails().add(email2);

		Project project1 = createProject("Project 1");
		Project project2 = createProject("Project 2");

		customer.getProjects().add(project1);
		customer.getProjects().add(project2);

		return customer;
	}

}
