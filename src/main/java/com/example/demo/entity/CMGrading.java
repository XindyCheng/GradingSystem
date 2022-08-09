package com.example.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Table(name = "CM_grading")
public class CMGrading {
	@Id
	private Integer id;
	private String cmname;
	private String unit;
	private Integer credibility;
	private Integer customerrelat;
	private Integer projectsupport;
	private Integer personnelquality;
	private String comment;
	private Double total;

}
