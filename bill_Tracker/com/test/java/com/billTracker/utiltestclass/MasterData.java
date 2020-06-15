package com.billTracker.utiltestclass;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.billTracker.model.*;

public class MasterData {
	public static Billes getBillesDetails() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateOfEntry = formatter.parse("15-Jun-2020");
		Date dueDate = formatter.parse("15-Jul-2020");
		Billes billes = new Billes();
		billes.setId((long) 1);
		billes.setBillTitle("phone");
		billes.setCategory("vd");
		billes.setAmount(100.0);
		billes.setDateOfEntry(dateOfEntry);
		billes.setDueDate(dueDate);

		billes.setPaid("no");
		billes.setUnpaid("yes");
		billes.setActive(true);
		return billes;
	}

	public static Properties getProperties() throws IOException {
		FileReader reader = new FileReader("src//main//resources//database.properties");
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}

	public static LocalSessionFactoryBean getSession() throws IOException {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		Properties properties = getProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.root"));
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan("com.billTracker.model");
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		lsfb.setHibernateProperties(properties);
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb;
	}

	public static Billes getBillDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}