package repository.jdbc.util.impl;

import java.sql.Connection;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.ProjectAbstractJdbcTestAction;

public class ProjectGetByIdTestAction
		extends ProjectAbstractJdbcTestAction {

	public ProjectGetByIdTestAction(long projectId) {
		this.projectId = projectId;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		Project project = dao.getById(projectId);
		return new Object[] { project };
	}

}
