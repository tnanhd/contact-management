package com.example.contact.adapter.in.rest.user.controller;

import com.example.contact.adapter.in.rest.user.mapper.UserDetailsMapper;
import com.example.contact.adapter.in.rest.user.dto.response.UserDetails;
import com.example.contact.domain.port.in.user.GetUsersUseCase;
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

  @GetMapping()
  public ResponseEntity<List<UserDetails>> getUsers() {
    log.info("Received request to get all users at /v1/users");
    return ResponseEntity.ok(
        getUsersUseCase.execute().stream()
            .map(UserDetailsMapper.INSTANCE::mapFromDomainToUserDetails)
            .toList());
  }
}
