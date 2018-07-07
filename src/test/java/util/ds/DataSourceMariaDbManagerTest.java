package util.ds;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import repository.exception.DAOException;

public class DataSourceMariaDbManagerTest {

	@Test
	public void propertiesFromFileLoadedCorrectly() throws DAOException {

		Properties props = DataSourceMariaDbManager.getInstance()
				.getPropertiesFromFile();
		assertNotNull(props);
		assertNotNull(props.getProperty("url"));
		assertNotNull(props.getProperty("user"));
		assertNotNull(props.getProperty("passw"));
	}

	@Test
	public void dataSourceCreatedCorrectly() throws DAOException, SQLException {
		assertNotNull(DataSourceMariaDbManager.getInstance().getDataSource());
	}

	@Test
	public void dbConnectionGotCorrectly() throws SQLException, DAOException {
		assertNotNull(DataSourceMariaDbManager.getInstance().getDataSource()
				.getConnection());
	}

}
