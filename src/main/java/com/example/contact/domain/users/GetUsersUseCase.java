package com.example.contact.domain.users;

import java.util.List;

public record GetUsersUseCase(UserRepository userRepository) {

  public List<User> execute() {
    return userRepository.getAllUsers();
  }
}
