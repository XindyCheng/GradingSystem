package com.example.demo.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@Table(name = "PM_entry")
@NoArgsConstructor
@AllArgsConstructor
public class PMEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
	private String name;
	private String contractnumber;
	private String supplier;
	private String client;
	private Integer start;
	private Double total;
	private Integer state;
	private Integer bg;
	private String score;
	private String pmname;
	private String department;
	private String cmname;
	private String dmname;
	private String comment;

}
