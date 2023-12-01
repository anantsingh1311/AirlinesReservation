package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long passengerId;
	
	private String fname;// first name
	private String lname;//last name
	
	private String email;
	private String phone;
	private String gender;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private IdentificationType idType;
	
	

}
