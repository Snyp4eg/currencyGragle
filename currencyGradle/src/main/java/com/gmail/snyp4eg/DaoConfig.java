package com.gmail.snyp4eg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gmail.snyp4eg.reader.PropertyReader;

@ComponentScan
@Configuration
public class DaoConfig {
    protected static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    protected static final String URL = "jdbc:postgresql://localhost:5432/Currency";
    protected static final String USER_NAME = "taskuser";
    protected static final String PASSWORD = "313233";
    protected static final String QUERY_PATH = "./src/main/resources/sql/query.properties";

    @Bean
    public DriverManagerDataSource dataSourse() {
	DriverManagerDataSource getDataSourse = new DriverManagerDataSource();
	getDataSourse.setDriverClassName(DRIVER_CLASS_NAME);
	getDataSourse.setUrl(URL);
	getDataSourse.setUsername(USER_NAME);
	getDataSourse.setPassword(PASSWORD);
	return getDataSourse;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
	return new JdbcTemplate(dataSourse());
    }

    @Bean
    public PropertyReader queryReader() {
	return new PropertyReader(QUERY_PATH);
    }
}
