package com.synergisticit.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long flightId;
	
	private String flightNum;
	
	@NotEmpty
	private String departureCity;
	
	@NotEmpty
	private String arrivalCity;
	
	private Double ticketPrice;
	
	private int capacity;
	
	private int booked;
	
	
	
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate departureDate;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime departureTime;
	
	@ManyToOne
	private Airlines operatingAirlines;
	
	
	
	
	
	
	

}
