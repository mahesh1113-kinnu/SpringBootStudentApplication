package com.app.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.Data;

@Data
@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	@Size(min = 3, message = "First name must be at least 3 characters long")
	private String firstName;

	@Size(min = 3, message = "Last name must be at least 3 characters long")
	private String lastName;

	@NotNull(message = "Date of birth is mandatory")
	@AgeConstraint(message = "Age should be greater than 15 years and less than or equal to 20 years")
	private LocalDate dateOfBirth;

	@Pattern(regexp = "[MF]", message = "Valid values for gender are M or F")
	private String gender;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks cannot exceed 100")
	private int mark1;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks cannot exceed 100")
	private int mark2;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks cannot exceed 100")
	private int mark3;
	@Pattern(regexp = "[ABC]*", message = "Valid values for section are A, B, or C")
	private String section;

	
	

}
