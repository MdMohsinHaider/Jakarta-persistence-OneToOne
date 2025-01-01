package com.jsp.hibernate_onetoone_inidirectinal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aadhar {
	@Id
	private long aadharNumber;
	private String fatherName;
	private LocalDate dob;
	private String address;
}
