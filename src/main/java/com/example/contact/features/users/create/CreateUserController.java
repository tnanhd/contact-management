package com.example.contact.features.users.create;

import com.example.contact.features.users.shared.UserDetails;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Creating Controller", description = "Endpoints for managing users")
@RequiredArgsConstructor
public class CreateUserController {

  private final CreateUserHandler createUserHandler;

  @PostMapping
  public ResponseEntity<UserDetails> createUser(@Valid @RequestBody CreateUserRequest request) {
    return ResponseEntity.ok(createUserHandler.handle(request));
  }
}
