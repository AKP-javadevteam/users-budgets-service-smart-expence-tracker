package com.smartexpense.usersbudgets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

/**
 * Entity representing an application user.
 *
 * <p>Each user has a unique identifier, an email address (used as a login name),
 * optional display name, a default currency preference, and a creation timestamp.</p>
 *
 * <p>The Users & Budgets Service stores and manages user profile data,
 * which can be consumed by other services such as Forecasts or Reports.</p>
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;

    @Column(name = "default_currency", length = 3, nullable = false)
    private String defaultCurrency = "EUR";

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();
}
