package com.example.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	private Integer id;
	private Integer layer;
	private Integer pid;
	private String name;
	
}
