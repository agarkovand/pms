package repository.jdbc.util.impl;

import java.sql.Connection;

import repository.exception.DAOException;
import repository.jdbc.util.ProjectAbstractJdbcTestAction;

public class ProjectDeleteByParentTestAction
		extends ProjectAbstractJdbcTestAction {

	public ProjectDeleteByParentTestAction(Long customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public Object[] perform(Connection conn) throws DAOException {

		dao.set(conn);
		int affectedRowsCount = dao.deleteByParent(customer_id);
		return new Object[] { affectedRowsCount };
	}

}
