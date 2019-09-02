package com.ombrodrigo.circuitbreaker.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "DateTimeClient", url = "http://localhost:1234")
public interface DateTimeClient {

  @GetMapping("/")
  String getCurrentDateTime();
}
