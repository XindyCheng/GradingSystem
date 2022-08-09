package com.example.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "DM_grading")
public class DMGrading {
	@Id
	private Integer id;
	private String dmname;
	private String unit;
	private Integer constructability;
	private Integer technique;
	private Integer res_tl;
	private Integer compl_tl;
	private Integer deliver_quality;
	private Integer customer_satisfaction;
	private String comment;
	private Double total;
	
}
