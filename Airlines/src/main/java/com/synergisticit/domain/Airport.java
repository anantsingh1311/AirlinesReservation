package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airport {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long airportId;
	
	private String airportCity;
	
	private String airportCode;
	
	
	
	@OneToMany
	private List<Flight> arrivalFlights = new ArrayList<>();
	
	@OneToMany
	private List<Flight> departureFlights = new ArrayList<>();
	
}
