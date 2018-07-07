package repository.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import repository.exception.DAOException;
import util.drm.ConnectionUtil;

public class JdbcConnectionContextExecution
		implements ContextExecution {

	@Override
	public Object[] performAction(JdbcAction action)
			throws SQLException {

		Object[] result = null;

		try (Connection conn = ConnectionUtil.getConnection();) {

			try {

				System.out.println(
						"AutoCommit: " + conn.getAutoCommit());

				result = action.perform(conn);

				conn.commit();

			} catch (SQLException | DAOException ex) {
				conn.rollback();
			}

		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		return (result == null) ? new Object[0] : result;
	}

}
