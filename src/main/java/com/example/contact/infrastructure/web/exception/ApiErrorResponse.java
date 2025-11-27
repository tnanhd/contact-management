package com.example.contact.infrastructure.web.exception;

import java.time.Instant;

public record ApiErrorResponse(
    String timestamp, int status, String error, String path, String message) {
  public static ApiErrorResponse of(int status, String error, String path, String message) {
    return new ApiErrorResponse(Instant.now().toString(), status, error, path, message);
  }
}
