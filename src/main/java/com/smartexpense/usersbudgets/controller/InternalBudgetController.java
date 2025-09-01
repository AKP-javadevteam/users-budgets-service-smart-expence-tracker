package com.smartexpense.usersbudgets.controller;

import com.smartexpense.usersbudgets.dto.BudgetResponse;
import com.smartexpense.usersbudgets.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

/**
 * Internal REST controller for budget operations.
 *
 * <p>Provides restricted endpoints for inter-service
 * communication. Typically not exposed to end-users.</p>
 */

@RestController
@RequestMapping("/internal/budgets")
@RequiredArgsConstructor
public class InternalBudgetController {

    private final BudgetService budgetService;

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<BudgetResponse>> getBudgetsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(budgetService.getBudgetsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponse> getBudget(@PathVariable UUID id) {
        return ResponseEntity.ok(budgetService.getBudget(id));
    }
}
