package com.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.Expense;
import com.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;

	@Autowired
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public Expense saveExpense(Expense expense) {
		// Save the expense entity using Spring Data JPA
		return expenseRepository.save(expense);
	}

	public Integer insertExpense(Expense expense) {
		return expenseRepository.insertExpense(expense.getUserId(), expense.getExpenseDate(),
				expense.getExpenseDescription(), expense.getExpenseItemName(), expense.getAmount());
	}
}
