package com.example.contact.adapter.persistence.postgres.users;

import com.example.contact.adapter.persistence.postgres.users.mapper.UserMapper;
import com.example.contact.domain.users.User;
import com.example.contact.domain.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Primary
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {

  private final SpringDataUserRepository springDataUserRepository;
  private final UserMapper userMapper;

  @Override
  public boolean addUser(User user) {
    log.debug("Adding user with email: {}", user.contact().email());
    final var userEntity = userMapper.mapFromDomainToEntity(user);
    springDataUserRepository.save(userEntity);
    return true;
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    log.debug("Finding user with email: {}", email);
    return springDataUserRepository.findByEmail(email)
        .map(userMapper::mapFromEntityToDomain);
  }

  @Override
  public List<User> findUserByName(String name) {
    log.debug("Finding users with name containing: {}", name);
    return springDataUserRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name).stream()
        .map(userMapper::mapFromEntityToDomain)
        .toList();
  }

  @Override
  public boolean removeUserByEmail(String email) {
    log.debug("Removing user with email: {}", email);
    final var userEntity = springDataUserRepository.findByEmail(email);
    if (userEntity.isPresent()) {
      springDataUserRepository.delete(userEntity.get());
      return true;
    }
    return false;
  }

  @Override
  public List<User> getAllUsers() {
    log.debug("Retrieving all users from the database");
    return springDataUserRepository.findAll().stream()
        .map(userMapper::mapFromEntityToDomain)
        .toList();
  }
}
