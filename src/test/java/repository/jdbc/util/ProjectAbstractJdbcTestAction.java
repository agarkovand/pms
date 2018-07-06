package repository.jdbc.util;

import model.Project;
import repository.jdbc.JdbcProjectRepositoryImpl;

public abstract class ProjectAbstractJdbcTestAction
		implements AbstractJdbcTestAction {

	protected Project project;
	protected long projectId;
	protected long customerId;
	protected JdbcProjectRepositoryImpl dao = new JdbcProjectRepositoryImpl();

}
