package com.example.contact.domain.usecase.user;

import com.example.contact.domain.exception.EmailAlreadyExistsException;
import com.example.contact.domain.models.User;
import com.example.contact.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record CreateUserUseCase(UserRepository userRepository) {

  public User execute(User user) {
    log.debug("Executing CreateUserUseCase for user: [{}]", user);
    if (!user.isValidForCreation()) {
      log.info("User data is invalid for creation: [{}]", user.getSafeToPrintUserData());
      throw new IllegalArgumentException("Invalid user data");
    }

    if (userRepository.existsByEmail(user.email())) {
      log.info("User with email [{}] already exists", user.email());
      throw new EmailAlreadyExistsException(user.email());
    }

    return userRepository.addUser(user);
  }
}
