package com.ombrodrigo.circuitbreaker.service;

import com.ombrodrigo.circuitbreaker.connnector.ExternalRequestConnector;
import org.springframework.stereotype.Service;

@Service
public class ExternalRequestService {

  private final ExternalRequestConnector externalRequestConnector;

  public ExternalRequestService(ExternalRequestConnector externalRequestConnector) {
    this.externalRequestConnector = externalRequestConnector;
  }

  public String run() {
    return this.externalRequestConnector.run();
  }
}
