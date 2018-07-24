package dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.CustomerDao;
import model.Customer;

public class CustomerHibernateDao extends AbstractDao<Customer, Long>
		implements CustomerDao {

	@Override
	public Customer fetchEmails(Customer customer) {

		Session session = null;

		try {

			session = this.getSession();
			Query<Customer> query = session.createQuery(
					"SELECT cust FROM Customer AS cust JOIN FETCH cust.emails WHERE id = :id",
					Customer.class);

			customer = query.setParameter("id", customer.getId())
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return customer;
	}

	@Override
	public List<Customer> findCustomersByCountry(String country) {
		Session session = null;
		List<Customer> result;

		try {

			session = this.getSession();

			Query<Customer> query = session.createQuery(
					"SELECT cust FROM Customer AS cust WHERE country = :country",
					Customer.class);

			result = query.setParameter("country", country)
					.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return result;
	}

}
