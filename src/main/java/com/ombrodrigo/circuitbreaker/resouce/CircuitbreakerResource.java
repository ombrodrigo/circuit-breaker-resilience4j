package com.ombrodrigo.circuitbreaker.resouce;

import com.ombrodrigo.circuitbreaker.service.CircuitBreakerService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit")
public class CircuitbreakerResource {

  private final CircuitBreaker circuitBreaker;
  private final CircuitBreakerService circuitBreakerService;

  public CircuitbreakerResource(
      CircuitBreakerRegistry circuitBreakerRegistry, CircuitBreakerService circuitBreakerService) {
    this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("externalServiceCircuitBreaker");
    this.circuitBreakerService = circuitBreakerService;
  }

  @GetMapping("/execute")
  public String execute() {
    return Try.ofSupplier(
            CircuitBreaker.decorateSupplier(
                circuitBreaker, circuitBreakerService::runRequestExternalService))
        .recover(CircuitBreakerOpenException.class, "Circuit is Open!")
        .recover(RuntimeException.class, "fallback!")
        .get();
  }
}
