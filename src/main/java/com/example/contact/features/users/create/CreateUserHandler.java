package com.example.contact.features.users.create;

import com.example.contact.domain.models.User;
import com.example.contact.domain.usecase.user.CreateUserUseCase;
import com.example.contact.features.users.shared.UserDetails;
import com.example.contact.features.users.shared.UserDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserHandler {

  private final CreateUserUseCase createUserUseCase;

  public UserDetails handle(CreateUserRequest request) {
    final var user = User.builder()
        .name(new User.Name(request.firstName(), request.lastName()))
        .contact(new User.Contact(request.email(), request.phoneNumber()))
        .address(new User.Address(request.zipCode()))
        .build();
    final var createdUser = createUserUseCase.execute(user);
    return UserDetailsMapper.INSTANCE.mapFromDomainToUserDetails(createdUser);
  }
}
