package com.hp.gekko.ordermanagement.util;



import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(DatasourceConfiguration.class);
	

	@Bean
	DataSource dataSource(Environment env)
	{
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Doneg4August?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
		
	}

	
/*	@Bean
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("database.driver"));
		String dbUrl = System.getenv("FLYWAY_URL");
		if (StringUtils.isEmpty(dbUrl)) {
			dbUrl = env.getProperty("database.url");
		}
		dataSource.setUrl(dbUrl);
		String userName = System.getenv("username");
		if (StringUtils.isEmpty(userName)) {
			userName = env.getProperty("database.username");
		}
		dataSource.setUsername(userName);
		String password = System.getenv("password");
		if (StringUtils.isEmpty(password)) {
			password = env.getProperty("database.password");
		}
		dataSource.setPassword(password);
		LOG.debug("DB URL: {}", dbUrl);
		return dataSource;

	}*/
	
	
}
