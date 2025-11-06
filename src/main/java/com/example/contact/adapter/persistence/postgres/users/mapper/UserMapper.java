package com.example.contact.adapter.persistence.postgres.users.mapper;

import com.example.contact.adapter.persistence.postgres.users.UserEntity;
import com.example.contact.domain.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public UserEntity mapFromDomainToEntity(User user) {
    return UserEntity.builder()
        .id(user.id().value())
        .firstName(user.name().firstName())
        .lastName(user.name().lastName())
        .email(user.contact().email())
        .phoneNumber(user.contact().phoneNumber())
        .zipCode(user.address().zipCode())
        .build();
  }

  public User mapFromEntityToDomain(UserEntity userEntity) {
    return User.builder()
        .id(new User.UserId(userEntity.getId()))
        .name(new User.Name(userEntity.getFirstName(), userEntity.getLastName()))
        .contact(new User.Contact(userEntity.getEmail(), userEntity.getPhoneNumber()))
        .address(new User.Address(userEntity.getZipCode()))
        .build();
  }
}
