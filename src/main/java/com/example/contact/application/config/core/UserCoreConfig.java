package com.example.contact.application.config.core;

import com.example.contact.domain.users.GetUsersUseCase;
import com.example.contact.domain.users.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCoreConfig {

  @Bean
  public GetUsersUseCase getUsersUseCase(UserRepository userRepository) {
    return new GetUsersUseCase(userRepository);
  }
}
