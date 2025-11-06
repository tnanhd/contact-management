package com.example.contact.adapter.persistence.inmemory;

import com.example.contact.domain.users.User;
import com.example.contact.domain.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class InMemoryUserRepository implements UserRepository {
  private List<User> users;

  public boolean addUser(User user) {
    log.debug("Adding user: {}", user);
    if (!user.name().isValidName() || !user.contact().isValidContact()) {
      log.debug("User data is invalid: {}", user);
      return false;
    }

    users.add(user);
    return true;
  }

  public Optional<User> findUserByEmail(String email) {
    log.debug("Finding user by email: {}", email);
    return users.stream().filter(user -> user.contact().email().equals(email)).findFirst();
  }

  public boolean removeUserByEmail(String email) {
    log.debug("Removing user by email: {}", email);
    final var user = findUserByEmail(email);
    if (user.isPresent()) {
      users.remove(user.get());
      return true;
    }
    return false;
  }

  public List<User> findUserByName(String name) {
    log.debug("Finding user by name containing: {}", name);
    if (StringUtils.isEmpty(name)) {
      return List.of();
    }
    return users.stream()
        .filter(user -> user.name().getFullName().toLowerCase().contains(name.toLowerCase()))
        .toList();
  }

  public List<User> getAllUsers() {
    log.debug("Getting all users");
    return users;
  }
}
