package com.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.Expense;
import com.expensetracker.response.CreateExpenseResponse;
import com.expensetracker.service.ExpenseService;

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
}
