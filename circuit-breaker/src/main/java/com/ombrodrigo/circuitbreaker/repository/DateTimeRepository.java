package com.ombrodrigo.circuitbreaker.repository;

import com.ombrodrigo.circuitbreaker.exception.ConnectorException;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class DateTimeRepository {

  public String getCurrentDateTime() throws ConnectorException {
    RestTemplate restTemplate = new RestTemplate();

    URI uri = URI.create("http://localhost:1234");

    try {
      return restTemplate.getForObject(uri, String.class);
    } catch (ResourceAccessException exception) {
      throw new ConnectorException(exception.getMessage(), exception);
    }
  }
}
