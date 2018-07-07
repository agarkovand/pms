package app.parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import app.exception.ApplicationException;
import model.Project;

public class ProjectParserTest {

	ProjectParser testedObj;

	@Before
	public void setUp() {
		testedObj = new ProjectParser();
	}

	@Test
	public void whenValidDataLine_RelevantProjectObjectShouldBeCreated()
			throws ApplicationException {

		// name,project_start,planned_finish,actual_finish,customer_id
		String projectData = "Pr6,2016-01-01,,,3";
		Object[] result = testedObj.parse(projectData);

		assertNotNull(result[0]);
		assertNotNull(result[1]);

		Project project = (Project) result[1];

		assertEquals("Pr6", project.getName());
		assertEquals(LocalDate.parse("2016-01-01"), project.getProject_start());

	}

}
