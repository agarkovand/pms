package app.parsers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import app.exception.ApplicationException;
import model.Project;

/**
 * Sample line representing the Project object: (Pr6,2016-01-01,,,3) Last
 * element in the line represents the Foreign Key to Customer.
 *
 */
public class ProjectParser extends AbstractEntityParser<Project> {

	private static final int NUMBER_OF_TOKENS = 5;
	private final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

	@Override
	public Object[] parse(String line) throws ApplicationException {

		checkNullOrEmpty(line);

		String[] tokens = line.split(",");

		checkNumberOfTokens(tokens.length, NUMBER_OF_TOKENS);

		long id = Long.parseLong(tokens[4]);

		String name = tokens[0];

		Date project_start = parseDate(tokens[1]);
		Date planned_finish = parseDate(tokens[2]);
		Date actual_finish = parseDate(tokens[3]);

		Project project = new Project(name, project_start, planned_finish,
				actual_finish);

		return new Object[] { id, project };
	}

	private Date parseDate(String dateString) {

		try {
			return new Date(sdf.parse(dateString).getTime());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
