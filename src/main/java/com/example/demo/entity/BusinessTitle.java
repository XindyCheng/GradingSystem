package com.example.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "business_title")
@NoArgsConstructor
@AllArgsConstructor
public class BusinessTitle {
    @Id
    private Integer id;
    private String contact;
    private String left;
    private String right;
}
