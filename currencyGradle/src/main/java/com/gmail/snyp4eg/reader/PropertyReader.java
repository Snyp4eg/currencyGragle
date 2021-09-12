package com.gmail.snyp4eg.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyReader {
  private static final Logger logger = LoggerFactory.getLogger(PropertyReader.class);
  private String propertyPath;

  public PropertyReader() {

  }

  public PropertyReader(String propertyPath) {
    this.propertyPath = propertyPath;
  }

  public void setPropertyPath(String propertyPath) {
    this.propertyPath = propertyPath;
  }

  public String read(String key) {
    Properties properties = new Properties();
    try (InputStream reader = Files.newInputStream(Paths.get(propertyPath))) {
      properties.load(reader);
    } catch (IOException ex) {
      logger.error(ex.getMessage(), ex);
    }
    return properties.getProperty(key);
  }
}
