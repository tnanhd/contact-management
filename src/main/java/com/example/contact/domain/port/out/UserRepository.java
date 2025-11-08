package com.example.contact.domain.port.out;

import com.example.contact.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  boolean addUser(User user);

  Optional<User> findUserByEmail(String email);

  List<User> findUserByName(String name);

  boolean removeUserByEmail(String email);

  List<User> getAllUsers();
}
