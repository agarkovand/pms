package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.actions.ProjectAction;

public class ProjectUpdateAction
		extends ProjectAction {

	public ProjectUpdateAction(Project existingProject) {

		this.project = existingProject;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.update(project);
		return new Object[] { affectedRowsCount };
	}

}
