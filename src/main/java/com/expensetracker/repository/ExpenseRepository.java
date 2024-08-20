package com.expensetracker.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByUserId(Long userId);
	
	void deleteExpenseById(Long id);
	
	 @Procedure(name = "InsertExpense")
	 Integer insertExpense(
	        @Param("p_user_id") Long userId,
	        @Param("p_expense_date") Date expenseDate,
	        @Param("p_expense_description") String expenseDescription,
	        @Param("p_item") String item,
	        @Param("p_amount") BigDecimal amount
	 );
	 
//	 @Modifying
//	 @Query("UPDATE expenses e SET e.expenseDate = :expenseDate, e.expenseDescription = :expenseDescription, e.expenseTitle = :expenseTitle, e.amount = :amount WHERE e.expenseId = :id")
//	 void updateExpense(
//	     @Param("id") Long id,
//	     @Param("expenseDate") Date expenseDate,
//	     @Param("expenseDescription") String expenseDescription,
//	     @Param("expenseTitle") String expenseTitle,
//	     @Param("amount") BigDecimal amount
//	 );
	
}
