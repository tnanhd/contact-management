package com.example.contact.adapter.out.persistence.postgres.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String email);

  List<UserEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String q1, String q2);
}
