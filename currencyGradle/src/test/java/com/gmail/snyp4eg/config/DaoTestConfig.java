package com.gmail.snyp4eg.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.gmail.snyp4eg.reader.PropertyReader;

@Configuration
public class DaoTestConfig {
  protected static final String SCHEMA_TEST_PATH = "sql/schemaTest.sql";
  protected static final String DATA_TEST_PATH = "sql/dataTest.sql";
  protected static final String QUERY_PATH = "./src/main/resources/sql/query.properties";

  @Bean
  public DataSource dataSourseTest() {
    DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript(SCHEMA_TEST_PATH)
        .addScript(DATA_TEST_PATH).build();
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplateTest() {
    return new JdbcTemplate(dataSourseTest());
  }

  @Bean
  public PropertyReader queryReaderTest() {
    return new PropertyReader(QUERY_PATH);
  }
}
