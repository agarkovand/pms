package repository.jdbc;

import static org.junit.Assert.fail;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import model.Project;

public class JdbcProjectRepositoryImplTest {

	Project existingProject;

	@Before
	public void setUp() {
		existingProject = new Project("Pr6", Date.valueOf("2016-01-01"),
				Date.valueOf("2020-12-31"), null);
	}

	@Test
	public void testSave() {

	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
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
