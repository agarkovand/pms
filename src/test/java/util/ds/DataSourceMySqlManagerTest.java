package util.ds;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import dao.exception.DAOException;

public class DataSourceMySqlManagerTest {

	@Test
	public void propertiesFromFileLoadedCorrectly() throws DAOException {

		Properties props = DataSourceMySqlManager.getInstance()
				.getPropertiesFromFile();
		assertNotNull(props);
		assertNotNull(props.getProperty("url"));
		assertNotNull(props.getProperty("user"));
		assertNotNull(props.getProperty("passw"));
	}

	@Test
	public void dataSourceCreatedCorrectly() throws DAOException, SQLException {
		assertNotNull(DataSourceMySqlManager.getInstance().getDataSource());
	}

	@Test
	public void dbConnectionGotCorrectly() throws SQLException, DAOException {
		assertNotNull(DataSourceMySqlManager.getInstance().getDataSource()
				.getConnection());
	}

}
