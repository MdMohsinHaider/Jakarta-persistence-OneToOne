package com.jsp.hibernate_onetoone_inidirectinal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phone;
	
//	@OneToOne
//	private Aadhar aadhar;\
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Aadhar aadhar;
}
