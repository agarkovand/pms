package util.drm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import repository.DAOException;

public class ConnectionUtil {

	private static final String PROP_FILE_NAME = "db.properties";
	private static final String URL_PROP_NAME = "url";
	private static final String USER_PROP_NAME = "user";
	private static final String PASSW_PROP_NAME = "passw";

	private static Properties props;

	static {
		try {
			props = getPropertiesFromFile();
		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static String url;
	private static String user;
	private static String passw;
	private static String urlString;

	static {
		try {
			url = getProperty(URL_PROP_NAME, props);
			user = getProperty(USER_PROP_NAME, props);
			passw = getProperty(PASSW_PROP_NAME, props);
		} catch (DAOException ex) {
			System.out.println(ex.getMessage());
		}

		urlString = String.format("%s?user=%s&password=%s", url, user, passw);

		System.out.println(urlString);
	}

	public static synchronized Connection getConnection() throws DAOException {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(urlString);
		} catch (SQLException ex) {
			throw new DAOException("Error getting connection", ex);
		}

		return connection;

	}

	private static String getProperty(String property, Properties props)
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

	protected static Properties getPropertiesFromFile() throws DAOException {

		Properties props = new Properties();

		try (InputStream propStreamFromFile = ConnectionUtil.class
				.getClassLoader().getResourceAsStream(PROP_FILE_NAME);) {

			loadProperties(propStreamFromFile, props);

		} catch (IOException ex) {
			throw new DAOException(ex.getMessage());
		}

		return props;
	}

	private static void loadProperties(InputStream propStreamFromFile,
			Properties props) throws IOException {

		if (propStreamFromFile == null) {
			throw new IOException("Property file " + PROP_FILE_NAME
					+ " not found in the classpath.");
		}

		props.load(propStreamFromFile);
	}

}
