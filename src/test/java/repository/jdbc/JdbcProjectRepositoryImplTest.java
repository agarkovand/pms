package repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.Project;
import repository.jdbc.util.JdbcRepositoryTestUtil;
import repository.jdbc.util.impl.ProjectDeleteByParentTestAction;
import repository.jdbc.util.impl.ProjectUpdateTestAction;

public class JdbcProjectRepositoryImplTest {

	Project existingProject;
	long customer_id;

	@Before
	public void setUp() {
		existingProject = new Project("Pr6",
				LocalDate.parse("2016-01-01"),
				LocalDate.parse("2020-12-31"), null);
		existingProject.setId(1L);
		customer_id = 1L;
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil().performTest(
				new ProjectUpdateTestAction(existingProject));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		assertEquals(1, rowsAffected);
	}

	@Test
	public void testDeleteByParent() throws SQLException {

		Object[] result = new JdbcRepositoryTestUtil().performTest(
				new ProjectDeleteByParentTestAction(customer_id));

		int rowsAffected = (result.length == 0) ? 0 : (int) result[0];

		System.out.println(rowsAffected);

		assertTrue(rowsAffected > 0);

	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
