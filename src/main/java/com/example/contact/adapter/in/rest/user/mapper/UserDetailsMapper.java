package com.example.contact.adapter.in.rest.user.mapper;

import com.example.contact.adapter.in.rest.user.dto.response.UserDetails;
import com.example.contact.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper {

  UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

  @Mapping(target = "id", source = "user.id.value")
  @Mapping(target = "firstName", source = "user.name.firstName")
  @Mapping(target = "lastName", source = "user.name.lastName")
  @Mapping(target = "email", source = "user.contact.email")
  @Mapping(target = "phoneNumber", source = "user.contact.phoneNumber")
  @Mapping(target = "zipCode", source = "user.address.zipCode")
  UserDetails mapFromDomainToUserDetails(User user);

}
