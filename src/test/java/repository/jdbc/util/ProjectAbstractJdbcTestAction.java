package repository.jdbc.util;

import model.Project;
import repository.jdbc.JdbcProjectRepositoryImpl;

public abstract class ProjectAbstractJdbcTestAction
		implements AbstractJdbcTestAction {

	protected Project project;
	protected Long projectId;
	protected Long customerId;
	protected JdbcProjectRepositoryImpl dao = new JdbcProjectRepositoryImpl();

}
