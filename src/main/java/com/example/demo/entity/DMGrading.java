package com.example.demo.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Table(name = "DM_grading")
public class DMGrading {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
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
