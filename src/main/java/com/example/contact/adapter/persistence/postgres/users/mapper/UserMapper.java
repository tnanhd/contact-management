package com.example.contact.adapter.persistence.postgres.users.mapper;

import com.example.contact.adapter.persistence.postgres.users.UserEntity;
import com.example.contact.domain.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "id", source = "user.id.value")
  @Mapping(target = "firstName", source = "user.name.firstName")
  @Mapping(target = "lastName", source = "user.name.lastName")
  @Mapping(target = "email", source = "user.contact.email")
  @Mapping(target = "phoneNumber", source = "user.contact.phoneNumber")
  @Mapping(target = "zipCode", source = "user.address.zipCode")
  UserEntity mapFromDomainToEntity(User user);

  @Mapping(target = "id", expression = "java(new User.UserId(userEntity.getId()))")
  @Mapping(target = "name", expression = "java(new User.Name(userEntity.getFirstName(), userEntity.getLastName()))")
  @Mapping(target = "contact", expression = "java(new User.Contact(userEntity.getEmail(), userEntity.getPhoneNumber()))")
  @Mapping(target = "address", expression = "java(new User.Address(userEntity.getZipCode()))")
  User mapFromEntityToDomain(UserEntity userEntity);
}
