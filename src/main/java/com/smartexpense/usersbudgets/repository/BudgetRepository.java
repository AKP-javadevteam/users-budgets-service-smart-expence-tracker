package com.smartexpense.usersbudgets.repository;

import com.smartexpense.usersbudgets.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for managing {@link Budget} entities.
 *
 * <p>Provides CRUD operations on the budgets table.
 * Exposes a finder method for retrieving all budgets belonging to
 * a specific user for a given month.</p>
 */

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
    List<Budget> findByUserIdAndMonth(UUID userId, String month);
}
