package service.exception;

import java.sql.SQLException;

public class ServiceException extends Exception {

	public ServiceException(String string, SQLException cause) {
		super(string, cause);
	}

}
