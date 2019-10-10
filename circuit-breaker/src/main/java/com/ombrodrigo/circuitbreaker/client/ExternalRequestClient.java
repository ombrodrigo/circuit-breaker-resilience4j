package com.ombrodrigo.circuitbreaker.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ExternalRequestClient", url = "http://localhost:1234")
public interface ExternalRequestClient {

  @GetMapping("/200")
  String response200();

  @GetMapping("/200-slow")
  String responseSlow();

  @GetMapping("/408")
  String response408();

  @GetMapping("/500")
  String response500();
}
