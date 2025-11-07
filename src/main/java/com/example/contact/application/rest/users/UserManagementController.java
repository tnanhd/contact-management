package com.example.contact.application.rest.users;

import com.example.contact.application.rest.users.mapper.UserDetailsMapper;
import com.example.contact.application.rest.users.model.response.UserDetails;
import com.example.contact.domain.users.GetUsersUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserManagementController {

  private final GetUsersUseCase getUsersUseCase;
  private final UserDetailsMapper userDetailsMapper;

  @GetMapping()
  public ResponseEntity<List<UserDetails>> getUsers() {
    log.info("Received request to get all users at /v1/users");
    return ResponseEntity.ok(
        getUsersUseCase.execute().stream()
            .map(userDetailsMapper::mapFromDomainToUserDetails)
            .toList());
  }
}
