package com.example.contact.features.users.shared;

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
