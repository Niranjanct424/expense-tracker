package com.expensetracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Builder
@Getter
@ToString
@Table(name = "user_table")
public class UserEntity {
	@Id
	private Long id;
	private String username;
	private String phoneNumber;
	private String email;
	private String details;

	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String username, String phoneNumber, String email, String details) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.details = details;
	}

}
