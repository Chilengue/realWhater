package mati.com.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mati.com.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
