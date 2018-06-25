package util.drm;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.junit.Test;

import repository.DAOException;

public class ConnectonUtilTest {

	@Test
	public void connectionCreatedCorrectly() throws DAOException {
		assertNotNull(ConnectonUtil.getConnection());
	}

	@Test
	public void propertiesFromFileLoadedCorrectly() throws DAOException {
		Properties props = ConnectonUtil.getPropertiesFromFile();
		assertNotNull(props);
		assertNotNull(props.getProperty("url"));
		assertNotNull(props.getProperty("user"));
		assertNotNull(props.getProperty("passw"));
	}

}
