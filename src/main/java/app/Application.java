package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.exception.ApplicationException;
import app.parsers.AbstractEntityParser;
import app.parsers.ProjectParser;
import model.Customer;
import model.Project;
import repository.StrongEntityRepository;
import repository.exception.DAOException;
import service.CustomerService;
import service.exception.ServiceException;
import util.drm.ConnectionUtil;

public class Application {

	private static String customers_file = "/data/customers_to_add.csv";
	private static String projects_file = "/data/projects_to_add.csv";

	public static void main(String[] args)
			throws ApplicationException, ServiceException {

		System.out.println(new CustomerService().getById(2L));
		System.out.println(new CustomerService().getAll());

		Customer customer = new Customer();
		customer.setId(2L);
		System.out.println(
				"Deleting customer with id: " + customer.getId());

		int rowsAffected = new CustomerService().delete(customer);

		System.out.println(rowsAffected + " customer deleted.");

		System.out.println(new CustomerService().getAll());

	}

	public static void populateCustomersWithProjectsFromCsvFile(
			Map<Long, Customer> customers, String projects_file)
			throws ApplicationException {

		Map<Long, Project> projects = collectEntitiesFromCsvFile(
				projects_file, new ProjectParser());

		// for each project entry (<id,project>
		for (Map.Entry<Long, Project> projectEntry : projects
				.entrySet()) {

			// get corresponding customer by id
			Long id = projectEntry.getKey();
			Customer customer = customers.get(id);

			// put project to its customer's list of projects
			Project project = projectEntry.getValue();
			customer.addProject(project);
		}

	}

	public static <T> void saveEntitiesToDB(List<T> t,
			StrongEntityRepository<T> repo) {

		for (T item : t) {

			try (Connection conn = ConnectionUtil.getConnection();) {

				repo.set(conn);

				try {
					repo.save(item);
				} catch (DAOException ex) {
					conn.rollback();
				}

				conn.commit();

			} catch (SQLException | DAOException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	public static <T> Map<Long, T> collectEntitiesFromCsvFile(
			String fileName, AbstractEntityParser<T> entityParser)
			throws ApplicationException {

		Map<Long, T> items = new HashMap<>();
		String line;
		Object[] item;

		try (InputStream is = Application.class
				.getResourceAsStream(fileName);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader bfr = new BufferedReader(isr);) {

			while ((line = bfr.readLine()) != null) {
				item = entityParser.parse(line);
				items.put((Long) item[0], (T) item[1]);
			}

		} catch (FileNotFoundException e) {
			throw new ApplicationException(
					"File not found: " + fileName);
		} catch (IOException e) {
			throw new ApplicationException(
					"Problem reading file: " + fileName);
		}

		return items;
	}
}
