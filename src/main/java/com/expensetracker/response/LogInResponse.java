package com.expensetracker.response;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LogInResponse {
	
	private String status;

	public LogInResponse(String status) {
		super();
		this.status = status;
	}
	
}