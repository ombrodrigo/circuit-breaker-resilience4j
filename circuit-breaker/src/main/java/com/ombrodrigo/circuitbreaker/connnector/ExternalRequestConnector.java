package com.ombrodrigo.circuitbreaker.connnector;

import com.ombrodrigo.circuitbreaker.exception.ConnectorException;
import com.ombrodrigo.circuitbreaker.repository.DateTimeRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
@Retry(name = "externalRequest")
@RateLimiter(name = "externalRequest")
@CircuitBreaker(name = "externalRequest", fallbackMethod = "fallback")
public class ExternalRequestConnector {

  private DateTimeRepository dateTimeRepository;

  public ExternalRequestConnector(DateTimeRepository dateTimeRepository) {
    this.dateTimeRepository = dateTimeRepository;
  }

  @Bulkhead(name = "externalRequest")
  public String getCurrentDateTime() {
    return dateTimeRepository.getCurrentDateTime();
  }

  public String fallback(ConnectorException ex) {
    return "Unavailable service.";
  }

  private String fallback(Throwable ex) {
    return "Recovered Throwable.";
  }
}
