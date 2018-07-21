package dao.exception;

import java.sql.SQLException;

public class DAOException extends Exception {

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Exception ex) {
		super(message, ex);
	}

	public DAOException(SQLException ex) {
		super(ex);
	}
}