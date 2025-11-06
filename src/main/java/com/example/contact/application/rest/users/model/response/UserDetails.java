package com.example.contact.application.rest.users.model.response;

import lombok.Builder;

@Builder
public record UserDetails(
    String id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String zipCode
) {}
