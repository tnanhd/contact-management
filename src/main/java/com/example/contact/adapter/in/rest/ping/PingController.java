package com.example.contact.adapter.in.rest.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class PingController {

  @GetMapping()
  public String checkHealth() {
    return "Pong! The application is running!";
  }
}
