package com.example.contact.infrastructure.persistence.user;

import com.example.contact.domain.models.User;
import com.example.contact.domain.repository.UserRepository;
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

  @Override
  public User addUser(User user) {
    log.debug("Adding user: email=[{}]", user.email());
    final var userEntity = UserMapper.INSTANCE.mapFromDomainToEntity(user);
    final var savedInstance = springDataUserRepository.save(userEntity);
    return UserMapper.INSTANCE.mapFromEntityToDomain(savedInstance);
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    log.debug("Finding user: email=[{}]", email);
    return springDataUserRepository
        .findByEmail(email)
        .map(UserMapper.INSTANCE::mapFromEntityToDomain);
  }

  @Override
  public List<User> findUserByName(String name) {
    log.debug("Finding users by name: key=[{}]", name);
    return springDataUserRepository
        .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name)
        .stream()
        .map(UserMapper.INSTANCE::mapFromEntityToDomain)
        .toList();
  }

  @Override
  public boolean removeUserByEmail(String email) {
    log.debug("Removing user: email=[{}]", email);
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
        .map(UserMapper.INSTANCE::mapFromEntityToDomain)
        .toList();
  }
}
