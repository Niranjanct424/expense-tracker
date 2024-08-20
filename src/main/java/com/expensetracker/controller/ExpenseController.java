package com.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.Expense;
import com.expensetracker.response.CreateExpenseResponse;
import com.expensetracker.service.ExpenseService;

@CrossOrigin
@RestController
@RequestMapping("v1/api/user/expenses")
public class ExpenseController {
	
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public ResponseEntity<CreateExpenseResponse> insertExpense(@RequestBody Expense expense) {
    	CreateExpenseResponse response = null;
    	Integer rowCount = expenseService.insertExpense(expense);
    	if (rowCount == 1)
    		response = new CreateExpenseResponse("Success");
    	else
    		response = new CreateExpenseResponse("Failed");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{userId}/summary")
    public ResponseEntity<List<Expense>> getExpensesByUserId(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.findExpensesByUserId(userId);
        return ResponseEntity.ok(expenses);
    }
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
	@PutMapping("update/{id}")
	public ResponseEntity<Void> updateExpense( @PathVariable Long id , @RequestBody Expense expenseUpdateRequest) {
        Expense updated = expenseService.updateExpense(id, expenseUpdateRequest);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
}
