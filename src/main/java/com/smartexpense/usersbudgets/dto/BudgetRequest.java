package com.smartexpense.usersbudgets.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO representing the client request to create a new budget.
 *
 * <p>Contains the category name, budget amount, target month (YYYY-MM),
 * and the currency code. Validation annotations enforce correctness.</p>
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetRequest {
    @NotBlank
    private String category;

    @NotNull
    @Positive
    private Double amount;

    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}", message = "Month must be in format YYYY-MM")
    private String month;

    @NotBlank
    @Size(min = 3, max = 3)
    private String currency;
}
