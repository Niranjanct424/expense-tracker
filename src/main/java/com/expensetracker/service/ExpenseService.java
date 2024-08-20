package com.expensetracker.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public List<Expense> findExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }
	
	@Transactional
	public void deleteExpenseById(Long id) {
        expenseRepository.deleteExpenseById(id);
    }
	
	@Transactional
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        
        Expense updatedRequest = existingExpense.get();
        // Update the fields you want to change
        updatedRequest.setExpenseDate(updatedExpense.getExpenseDate());
        updatedRequest.setExpenseDescription(updatedExpense.getExpenseDescription());
        updatedRequest.setExpenseItemName(updatedExpense.getExpenseItemName());
        updatedRequest.setAmount(updatedExpense.getAmount());

        // Save the updated entity
        return expenseRepository.save(updatedRequest);
    }
}
