package com.smartexpense.usersbudgets.dto;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

/**
 * DTO representing the response payload for a user resource.
 *
 * <p>Returned to clients after a user profile is created or retrieved.
 * Contains identifiers, email, optional display name, default currency,
 * and creation timestamp.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID userId;
    private String email;
    private String name;
    private String defaultCurrency;
    private Instant createdAt;
}
