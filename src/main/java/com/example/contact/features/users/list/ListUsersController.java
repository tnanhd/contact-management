package com.example.contact.features.users.list;

import com.example.contact.features.users.shared.UserDetails;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Listing Controller", description = "Endpoints for managing users")
@RequiredArgsConstructor
public class ListUsersController {

  private final ListUsersHandler listUsersHandler;

  @GetMapping()
  public ResponseEntity<List<UserDetails>> getUsers() {
    log.info("Received request to get all users at /v1/users");
    return ResponseEntity.ok(listUsersHandler.handle());
  }
}
