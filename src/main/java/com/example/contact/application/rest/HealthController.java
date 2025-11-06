package com.example.contact.application.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthController {

  @GetMapping("/check")
  public String checkHealth() {
    return "Healthy, the application is running happily!";
  }
}
