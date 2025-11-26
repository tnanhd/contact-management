package com.example.contact.features.users.create;

public record CreateUserRequest(
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String zipCode
) {}
