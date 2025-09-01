package com.smartexpense.usersbudgets.service.impl;

import com.smartexpense.usersbudgets.dto.UserRequest;
import com.smartexpense.usersbudgets.dto.UserResponse;
import com.smartexpense.usersbudgets.entity.User;
import com.smartexpense.usersbudgets.repository.UserRepository;
import com.smartexpense.usersbudgets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of {@link UserService}.
 *
 * <p>Contains business logic for managing user profiles.
 * Persists data with {@link UserRepository} and maps
 * between entity and DTO objects.</p>
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User(
                UUID.randomUUID(),
                request.getName(),
                request.getEmail()
        );
        return toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUser(UUID id) {
        return userRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(UUID id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
