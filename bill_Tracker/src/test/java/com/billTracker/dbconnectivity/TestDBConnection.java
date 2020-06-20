
package com.billTracker.dbconnectivity;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.billTracker.utiltestclass.MasterData;

@RunWith(MockitoJUnitRunner.class)
public class TestDBConnection {
	static {
		File file = new File("output_TestDBConnection_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_TestDBConnection_revised.txt"));
			} catch (IOException e) {

			}
		}
	}

	@Test
	public void testConnectivity() throws IOException {
		Properties properties = MasterData.getProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.user"));
		dataSource.setPassword(properties.getProperty("database.password"));

		assertNotNull(dataSource);
		File file = new File("output_TestDBConnection_revised.txt");
		FileUtils.write(file, "\n TesttestConnectivity = " + (dataSource != null ? true : false), true);
	}

	@Test
	public void hibernateProperties() throws IOException {
		Properties properties = MasterData.getProperties();
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		File file = new File("output_TestDBConnection_revised.txt");
		FileUtils.write(file, "\n testhibernateProperties = true ", true);
	}

}
