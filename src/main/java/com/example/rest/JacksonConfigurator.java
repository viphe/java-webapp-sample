package com.example.rest;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Provides configured ObjectMappers.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

  private final ObjectMapper mapper = new ObjectMapper();


  public JacksonConfigurator() {
    mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.setDateFormat(Constants.getJsonDateFormat());
  }

  public ObjectMapper getMapper() {
    return mapper;
  }

  @Override
  public ObjectMapper getContext(Class<?> arg0) {
    return mapper;
  }
}