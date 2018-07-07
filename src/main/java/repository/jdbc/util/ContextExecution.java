package repository.jdbc.util;

import java.sql.SQLException;

public interface ContextExecution {

	public Object[] performAction(JdbcAction action)
			throws SQLException;
}
