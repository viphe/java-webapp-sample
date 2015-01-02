package com.example.rest;

import com.fasterxml.jackson.databind.*;

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
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
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