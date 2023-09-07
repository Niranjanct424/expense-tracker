package com.expensetracker.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	 @Procedure(name = "InsertExpense")
	 Integer insertExpense(
	        @Param("p_user_id") Long userId,
	        @Param("p_expense_date") Date expenseDate,
	        @Param("p_expense_description") String expenseDescription,
	        @Param("p_item") String item,
	        @Param("p_amount") BigDecimal amount
	    );
	
}
