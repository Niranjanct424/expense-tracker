package com.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
	
	private Long  id;
	private String username;
	private String phoneNumber;
	private String email;
	private String details;
//	private Salary salary;
//	private Expense expense;
//	private String currentBalance;

}
