package repository.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import repository.exception.DAOException;
import util.drm.ConnectionUtil;

public class JdbcConnectionTestContextExecution
		implements ContextExecution {

	@Override
	public Object[] performAction(JdbcAction action)
			throws SQLException {

		Object[] result = null;

		try (Connection conn = ConnectionUtil.getConnection();) {

			try {
				conn.setAutoCommit(false);
				System.out.println(
						"Autocommit: " + conn.getAutoCommit());

				result = action.perform(conn);

				ConnectionUtil.clearConnection(conn, null);

			} catch (SQLException | DAOException ex) {
				ConnectionUtil.clearConnection(conn, ex);
			}

		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		return (result == null) ? new Object[0] : result;
	}
}
