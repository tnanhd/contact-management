package com.example.contact.adapter.in.rest.ping;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Ping Controller", description = "Endpoints to check if the application is running")
@RequestMapping("/api/v1/ping")
public class PingController {

  @GetMapping()
  public String ping() {
    return "Pong! The application is running!";
  }
}
