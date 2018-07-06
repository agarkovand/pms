package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.ProjectAbstractJdbcTestAction;

public class ProjectUpdateTestAction
		extends ProjectAbstractJdbcTestAction {

	public ProjectUpdateTestAction(Project existingProject) {

		this.project = existingProject;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.update(project);
		return new Object[] { affectedRowsCount };
	}

}
