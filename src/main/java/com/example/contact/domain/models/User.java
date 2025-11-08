package com.example.contact.domain.models;

import io.micrometer.common.util.StringUtils;
import lombok.Builder;

@Builder
public record User(UserId id, Name name, Contact contact, Address address) {

  public record UserId(Long value) {
    public boolean isValidId() {
      return value != null && value > 0;
    }
  }

  public record Name(String firstName, String lastName) {

    public boolean isValidName() {
      return StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName);
    }

    public String getFullName() {
      return firstName + " " + lastName;
    }
  }

  public record Contact(String email, String phoneNumber) {
    public boolean isValidContact() {
      return StringUtils.isNotBlank(email);
    }
  }

  public record Address(String zipCode) {}
}
