package com.smartexpense.usersbudgets.service;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for handling user profiles.
 *
 * <p>Provides CRUD operations for user accounts.
 * Uses DTOs to separate persistence and API models.</p>
 */
public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUser(UUID id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(UUID id, UserRequest request);

    void deleteUser(UUID id);
}
