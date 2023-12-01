package com.synergisticit.domain;


import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ticketNum;

	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;
	
	private Boolean checkedIn;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate issuedDate;
	
	
}
