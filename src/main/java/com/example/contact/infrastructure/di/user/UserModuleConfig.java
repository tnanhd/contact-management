package com.example.contact.infrastructure.di.user;

import com.example.contact.domain.repository.UserRepository;
import com.example.contact.domain.usecase.user.GetUsersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserModuleConfig {

  @Bean
  public GetUsersUseCase getUsersUseCase(UserRepository userRepository) {
    return new GetUsersUseCase(userRepository);
  }
}
