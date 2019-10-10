package com.ombrodrigo.circuitbreaker.connnector;

import com.ombrodrigo.circuitbreaker.client.ExternalRequestClient;
import com.ombrodrigo.circuitbreaker.exception.ConnectorException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

@Component
@Retry(name = "externalRequest")
@RateLimiter(name = "externalRequest")
@CircuitBreaker(name = "externalRequest", fallbackMethod = "fallback")
public class ExternalRequestConnector {

  private ExternalRequestClient externalRequestClient;

  public ExternalRequestConnector(ExternalRequestClient externalRequestClient) {
    this.externalRequestClient = externalRequestClient;
  }

  @Bulkhead(name = "externalRequest")
  public String run() {
    return Try.ofCallable(getRandomMethodClient()).get();
  }

  private Callable<String> getRandomMethodClient() {
    List<Callable<String>> listMethods =
        Arrays.asList(
            () -> externalRequestClient.response200(),
            () -> externalRequestClient.responseSlow(),
            () -> externalRequestClient.response408(),
            () -> externalRequestClient.response500());

    Random random = new Random();
    return listMethods.get(random.nextInt(listMethods.size()));
  }

  public String fallback(ConnectorException ex) {
    return "Unavailable service.";
  }

  private String fallback(Throwable ex) {
    return "Recovered Throwable.";
  }
}
