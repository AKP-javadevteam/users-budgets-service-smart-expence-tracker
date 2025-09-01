package com.smartexpense.usersbudgets.service;

import com.smartexpense.usersbudgets.dto.BudgetRequest;
import com.smartexpense.usersbudgets.dto.BudgetResponse;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for handling budget operations.
 *
 * <p>Defines business logic for creating and retrieving user budgets.
 * Supports filtering by user and month. Uses DTOs to isolate
 * persistence layer from API models.</p>
 */
public interface BudgetService {

    BudgetResponse createBudget(UUID userId, BudgetRequest request);

    List<BudgetResponse> getBudgets(UUID userId, String month);

    void deleteBudget(UUID budgetId);
}
