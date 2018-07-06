package repository.jdbc.util.impl;

import java.sql.Connection;
import java.util.List;

import model.Project;
import repository.exception.DAOException;
import repository.jdbc.util.ProjectAbstractJdbcTestAction;

public class ProjectGetAllTestAction
		extends ProjectAbstractJdbcTestAction {

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		List<Project> projects = dao.getAll();
		return new Object[] { projects };
	}

}
