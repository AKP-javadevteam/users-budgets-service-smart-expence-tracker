package com.smartexpense.usersbudgets.repository;

import com.smartexpense.usersbudgets.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for managing {@link User} entities.
 *
 * <p>Provides CRUD operations on the users table.
 * Also exposes a finder method for retrieving a user by email.</p>
 */

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
