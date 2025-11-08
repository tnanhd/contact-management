package com.example.contact.domain.usecase.user;

import com.example.contact.domain.models.User;
import com.example.contact.domain.port.in.user.GetUsersUseCase;
import com.example.contact.domain.port.out.UserRepository;

import java.util.List;

public record GetUsersUseCaseImpl(UserRepository userRepository) implements GetUsersUseCase {

  @Override
  public List<User> execute() {
    return userRepository.getAllUsers();
  }
}
