package repository.jdbc.util.actions.impl;

import java.sql.Connection;

import repository.exception.DAOException;
import repository.jdbc.util.actions.ProjectAction;

public class ProjectDeleteByParentAction extends ProjectAction {

	public ProjectDeleteByParentAction(Long customer_id) {
		this.customerId = customer_id;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.deleteByParent(customerId);
		return new Object[] { affectedRowsCount };
	}

}
