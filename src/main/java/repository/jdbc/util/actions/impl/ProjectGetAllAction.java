package repository.jdbc.util.actions.impl;

import java.sql.Connection;
import java.util.List;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.actions.ProjectAction;

public class ProjectGetAllAction
		extends ProjectAction {

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		List<Project> projects = dao.getAll();
		return new Object[] { projects };
	}

}
