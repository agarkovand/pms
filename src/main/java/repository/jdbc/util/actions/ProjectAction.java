package repository.jdbc.util.actions;

import model.Project;
import repository.jdbc.JdbcProjectRepositoryImpl;
import repository.jdbc.util.JdbcAction;

public abstract class ProjectAction implements JdbcAction {

	protected Project project;
	protected long projectId;
	protected long customerId;
	protected JdbcProjectRepositoryImpl dao = new JdbcProjectRepositoryImpl();

}
