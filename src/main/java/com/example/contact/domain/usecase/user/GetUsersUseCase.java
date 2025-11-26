package com.example.contact.domain.usecase.user;

import com.example.contact.domain.models.User;
import com.example.contact.domain.repository.UserRepository;

import java.util.List;

public record GetUsersUseCase(UserRepository userRepository) {

  public List<User> execute() {
    return userRepository.getAllUsers();
  }
}
