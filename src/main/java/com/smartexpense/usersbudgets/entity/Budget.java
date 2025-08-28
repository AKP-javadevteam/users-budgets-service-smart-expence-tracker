package com.smartexpense.usersbudgets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

/**
 * Entity representing a monthly budget for a user.
 *
 * <p>A budget defines how much a user plans to spend in a specific category
 * (e.g., "Groceries", "Transport") for a given month (formatted YYYY-MM).
 * Each budget entry is tied to a user and may have its own currency.</p>
 *
 * <p>Budgets are later consumed by Forecasts & Insights services to generate
 * overspending alerts and financial insights.</p>
 */

@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Budget {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, precision = 12, scale = 2)
    private Double amount;

    @Column(nullable = false, length = 7)
    private String month; // YYYY-MM

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();
}
