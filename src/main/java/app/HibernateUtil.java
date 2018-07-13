package app;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(
					"There was an error building the factory");
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
