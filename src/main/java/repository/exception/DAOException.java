package repository.exception;

import java.sql.SQLException;

public class DAOException extends Exception {

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, SQLException ex) {
		super(message, ex);
	}

	public DAOException(SQLException ex) {
		super(ex);
	}
}