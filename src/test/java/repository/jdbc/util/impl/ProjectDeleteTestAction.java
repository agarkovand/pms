package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.ProjectAbstractJdbcTestAction;

public class ProjectDeleteTestAction
		extends ProjectAbstractJdbcTestAction {

	public ProjectDeleteTestAction(Project existingProject) {

		this.project = existingProject;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.delete(project);
		return new Object[] { affectedRowsCount };
	}

}
