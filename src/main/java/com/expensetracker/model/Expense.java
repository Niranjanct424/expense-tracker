package com.expensetracker.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Expense {
	
	private Date purchaseDate;
	private String purchaseItem;
	private String paidAmout;
	private String purchaseDetails;
	private String paymentType;
	
}
