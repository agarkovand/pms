package repository.jdbc.util;

import java.sql.Connection;

import repository.exception.DAOException;

public interface JdbcAction {

	Object[] perform(Connection conn) throws DAOException;

}
