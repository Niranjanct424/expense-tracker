package com.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Salary {
	
	private String salaryCredited;
	private String creditedDate;
	private String salaryDetails;
	
}
