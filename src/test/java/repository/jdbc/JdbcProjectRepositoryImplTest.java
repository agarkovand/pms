package repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Project;
import repository.jdbc.util.ContextExecution;
import repository.jdbc.util.JdbcConnectionTestContextExecution;
import repository.jdbc.util.actions.impl.ProjectDeleteAction;
import repository.jdbc.util.actions.impl.ProjectDeleteByParentAction;
import repository.jdbc.util.actions.impl.ProjectGetAllAction;
import repository.jdbc.util.actions.impl.ProjectGetByIdAction;
import repository.jdbc.util.actions.impl.ProjectUpdateAction;

public class JdbcProjectRepositoryImplTest {

	Project existingProject;
	long projectId;
	long customerId;

	ContextExecution executionInstance;

	@Before
	public void setUp() {
		existingProject = new Project("Pr6",
				LocalDate.parse("2016-01-01"),
				LocalDate.parse("2020-12-31"), null);
		existingProject.setId(1L);
		projectId = 1L;
		customerId = 1L;

		executionInstance = new JdbcConnectionTestContextExecution();
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() throws SQLException {

		Object[] result = executionInstance.performAction(
				new ProjectUpdateAction(existingProject));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testDeleteByParent() throws SQLException {

		Object[] result = executionInstance.performAction(
				new ProjectDeleteByParentAction(customerId));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		System.out.println(rowsAffected);

		assertTrue(rowsAffected > 0);

	}

	@Test
	public void testDelete() throws SQLException {

		Object[] result = executionInstance.performAction(
				new ProjectDeleteAction(existingProject));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testGetById() throws SQLException {

		Object[] result = executionInstance
				.performAction(new ProjectGetByIdAction(projectId));

		Project project = (result.length == 0) ? null
				: (Project) result[0];

		assertNotNull(project);
		assertEquals("Pr1", project.getName());

	}

	@Test
	public void testGetAll() throws SQLException {

		Object[] result = executionInstance
				.performAction(new ProjectGetAllAction());

		List<Project> projects = ((result.length == 0) ? null
				: (List<Project>) result[0]);

		assertNotNull(projects);
		assertTrue(projects.size() > 0);

		System.out.println(projects);

	}

}
