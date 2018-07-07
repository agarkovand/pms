package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.actions.ProjectAction;

public class ProjectGetByIdAction
		extends ProjectAction {

	public ProjectGetByIdAction(long projectId) {
		this.projectId = projectId;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		Project project = dao.getById(projectId);
		return new Object[] { project };
	}

}
