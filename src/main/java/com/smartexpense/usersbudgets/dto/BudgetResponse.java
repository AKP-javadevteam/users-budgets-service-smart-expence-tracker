package com.smartexpense.usersbudgets.dto;

import lombok.*;

import java.util.UUID;

/**
 * DTO representing the response payload for a budget resource.
 *
 * <p>Returned to clients after a budget is created or retrieved.
 * Contains identifiers, category, amount, month, and currency.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetResponse {
    private UUID budgetId;
    private UUID userId;
    private String category;
    private Double amount;
    private String month;
    private String currency;
}
