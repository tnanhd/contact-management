package com.example.contact.features.users.list;

import com.example.contact.features.users.shared.UserDetails;
import com.example.contact.features.users.shared.UserDetailsMapper;
import com.example.contact.domain.usecase.user.GetUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListUsersHandler {
  private final GetUsersUseCase getUsersUseCase;

  public List<UserDetails> handle() {
    return getUsersUseCase.execute().stream()
        .map(UserDetailsMapper.INSTANCE::mapFromDomainToUserDetails)
        .toList();
  }
}
