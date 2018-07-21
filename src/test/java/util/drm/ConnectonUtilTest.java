package util.drm;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.junit.Test;

import dao.exception.DAOException;

public class ConnectonUtilTest {

	@Test
	public void connectionCreatedCorrectly() throws DAOException {
		assertNotNull(ConnectionUtil.getConnection());
	}

	@Test
	public void propertiesFromFileLoadedCorrectly() throws DAOException {
		Properties props = ConnectionUtil.getPropertiesFromFile();
		assertNotNull(props);
		assertNotNull(props.getProperty("url"));
		assertNotNull(props.getProperty("user"));
		assertNotNull(props.getProperty("passw"));
	}

}
