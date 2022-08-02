package com.example.demo.entity;


import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.*;

@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private Integer id;
	private String name;
	private String password;
}

