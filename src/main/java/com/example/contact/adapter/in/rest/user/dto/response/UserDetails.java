package com.example.contact.adapter.in.rest.user.dto.response;

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
