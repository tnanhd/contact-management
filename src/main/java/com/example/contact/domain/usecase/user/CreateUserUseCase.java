package com.example.contact.domain.usecase.user;

import com.example.contact.domain.models.User;
import com.example.contact.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record CreateUserUseCase(UserRepository userRepository) {

  public User execute(User user) {
    if (validateUser(user)) {
      return userRepository.addUser(user);
    } else {
      throw new IllegalArgumentException("Invalid user data");
    }
  }

  private boolean validateUser(User user) {
    if (!user.name().isValidName()) {
      log.info("Invalid user name: {}", user.name().getFullName());
      return false;
    }

    if (!user.contact().isValidContact()) {
      log.info("Invalid user contact: {}", user.contact());
      return false;
    }

    return true;
  }
}
