package com.example.contact.infrastructure.di.user;

import com.example.contact.domain.port.in.user.GetUsersUseCase;
import com.example.contact.domain.usecase.user.GetUsersUseCaseImpl;
import com.example.contact.domain.port.out.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserModuleConfig {

  @Bean
  public GetUsersUseCase getUsersUseCase(UserRepository userRepository) {
    return new GetUsersUseCaseImpl(userRepository);
  }
}
