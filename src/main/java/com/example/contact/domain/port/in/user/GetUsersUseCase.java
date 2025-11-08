package com.example.contact.domain.port.in.user;

import com.example.contact.domain.models.User;

import java.util.List;

public interface GetUsersUseCase {
  List<User> execute();
}
