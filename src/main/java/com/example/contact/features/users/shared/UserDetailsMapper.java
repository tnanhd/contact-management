package com.example.contact.features.users.shared;

import com.example.contact.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper {

  UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

  @Mapping(target = "id", source = "user.id.value")
  UserDetails mapFromDomainToUserDetails(User user);
}
