package repository.jdbc.util;

import java.sql.Connection;

import repository.exception.DAOException;

public interface AbstractJdbcTestAction {

	public Object[] perform(Connection conn) throws DAOException;

}
