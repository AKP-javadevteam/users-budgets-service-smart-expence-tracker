package com.smartexpense.usersbudgets.controller;

import com.smartexpense.usersbudgets.dto.BudgetRequest;
import com.smartexpense.usersbudgets.dto.BudgetResponse;
import com.smartexpense.usersbudgets.service.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing user budgets.
 *
 * <p>Exposes endpoints for clients to create, update,
 * delete, and retrieve budget resources. Validates
 * incoming requests with {@link jakarta.validation.Valid}.</p>
 */

@RestController
@RequestMapping("/api/v1/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public ResponseEntity<BudgetResponse> createBudget(@Valid @RequestBody BudgetRequest request) {
        return ResponseEntity.ok(budgetService.createBudget(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponse> getBudget(@PathVariable UUID id) {
        return ResponseEntity.ok(budgetService.getBudget(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BudgetResponse>> getBudgetsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(budgetService.getBudgetsByUser(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetResponse> updateBudget(@PathVariable UUID id,
                                                       @Valid @RequestBody BudgetRequest request) {
        return ResponseEntity.ok(budgetService.updateBudget(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable UUID id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
