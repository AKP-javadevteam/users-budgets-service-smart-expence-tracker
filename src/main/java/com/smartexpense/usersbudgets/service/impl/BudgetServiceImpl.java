package com.smartexpense.usersbudgets.service.impl;

import com.smartexpense.usersbudgets.dto.BudgetRequest;
import com.smartexpense.usersbudgets.dto.BudgetResponse;
import com.smartexpense.usersbudgets.entity.Budget;
import com.smartexpense.usersbudgets.repository.BudgetRepository;
import com.smartexpense.usersbudgets.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of {@link BudgetService}.
 *
 * <p>Contains business logic for managing user budgets.
 * Persists data with {@link BudgetRepository} and maps
 * between entity and DTO objects.</p>
 */
@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    @Override
    public BudgetResponse createBudget(UUID userId, BudgetRequest request) {
        Budget budget = new Budget(
                UUID.randomUUID(),
                request.getCategory(),
                request.getAmount(),
                request.getMonth(),
                request.getCurrency(),
                userId
        );
        return toResponse(budgetRepository.save(budget));
    }

    @Override
    public List<BudgetResponse> getBudgets(UUID userId, String month) {
        return budgetRepository.findByUserIdAndMonth(userId, month).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBudget(UUID budgetId) {
        budgetRepository.deleteById(budgetId);
    }

    private BudgetResponse toResponse(Budget budget) {
        return BudgetResponse.builder()
                .budgetId(budget.getId())
                .userId(budget.getUserId())
                .category(budget.getCategory())
                .amount(budget.getAmount())
                .month(budget.getMonth())
                .currency(budget.getCurrency())
                .build();
    }
}
