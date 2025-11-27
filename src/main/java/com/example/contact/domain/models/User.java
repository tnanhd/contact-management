package com.example.contact.domain.models;

import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

@Builder
public record User(
    UserId id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String zipCode) {

  public record UserId(Long value) {
    public boolean isValidId() {
      return value != null && value > 0;
    }
  }

  public boolean isValidName() {
    return StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName);
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public boolean isValidContact() {
    return StringUtils.isNotBlank(email);
  }

  public boolean isValidForCreation() {
    return isValidName() && isValidContact();
  }

  public String getSafeToPrintUserData() {
    return "User{" +
        "id=" + (id != null ? id.value() : "null") +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + getMaskedPhoneNumber() + '\'' +
        ", zipCode='" + zipCode + '\'' +
        '}';
  }

  public String getMaskedPhoneNumber() {
    if (phoneNumber == null || phoneNumber.length() < 4) {
      return "****";
    }
    String lastFourDigits = phoneNumber.substring(phoneNumber.length() - 4);
    return "****" + lastFourDigits;
  }
}
