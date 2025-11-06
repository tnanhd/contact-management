package com.example.contact.application.rest.users.mapper;

import com.example.contact.application.rest.users.model.response.UserDetails;
import com.example.contact.domain.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

  public UserDetails mapFromDomainToUserDetails(User user) {
    return UserDetails.builder()
        .id(String.valueOf(user.id().value()))
        .firstName(user.name().firstName())
        .lastName(user.name().lastName())
        .email(user.contact().email())
        .phoneNumber(user.contact().phoneNumber())
        .zipCode(user.address().zipCode())
        .build();
  }
}
