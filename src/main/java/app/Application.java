package app;

import org.hibernate.SessionFactory;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtil
				.getSessionFactory();

		sessionfactory.openSession().beginTransaction();
		sessionfactory.close();

	}

}
