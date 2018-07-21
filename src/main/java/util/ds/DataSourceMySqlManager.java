package util.ds;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import dao.exception.DAOException;

public class DataSourceMySqlManager {

	private static final String PROP_FILE_NAME = "db.properties";
	private static final String URL_PROP_NAME = "url";
	private static final String USER_PROP_NAME = "user";
	private static final String PASSW_PROP_NAME = "passw";

	private MysqlDataSource dataSource;

	private DataSourceMySqlManager() {
		try {
			this.initializeDataSourceInstance();
		} catch (DAOException e) {
			System.out.println("Error creating Data Source");
		}
	}

	private static class LazyHolder {
		static final DataSourceMySqlManager INSTANCE = new DataSourceMySqlManager();
	}

	public static DataSourceMySqlManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	private void initializeDataSourceInstance() throws DAOException {

		Properties props = getPropertiesFromFile();
		String url = getProperty(URL_PROP_NAME, props);
		String user = getProperty(USER_PROP_NAME, props);
		String passw = getProperty(PASSW_PROP_NAME, props);

		dataSource = new MysqlDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(passw);
		try {
			dataSource.setServerTimezone("UTC");
		} catch (SQLException ex) {
			throw new DAOException("Error setting time zone on mysql server",
					ex);
		}

	}

	private String getProperty(String property, Properties props)
			throws DAOException {
		String value = props.getProperty(property);
		if (value == null) {
			throw new DAOException("Property '" + property
					+ "' not found in the configuration file.");
		} else if (value.isEmpty()) {
			System.out.println("Property '" + property
					+ "' in the configuration file is empty.");
		}
		return value;
	}

	protected Properties getPropertiesFromFile() throws DAOException {

		Properties props = new Properties();

		try (InputStream propStreamFromFile = DataSourceMySqlManager.class
				.getClassLoader().getResourceAsStream(PROP_FILE_NAME);) {

			loadProperties(propStreamFromFile, props);

		} catch (IOException ex) {
			throw new DAOException(ex.getMessage());
		}

		return props;
	}

	private void loadProperties(InputStream propStreamFromFile,
			Properties props) throws IOException {

		if (propStreamFromFile == null) {
			throw new IOException("Property file " + PROP_FILE_NAME
					+ " not found in the classpath.");
		}

		props.load(propStreamFromFile);
	}

}
