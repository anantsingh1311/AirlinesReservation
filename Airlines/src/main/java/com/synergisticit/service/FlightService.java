package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Flight;

public interface FlightService {
	
	public Flight saveFlight(Flight flight);
	public Flight findFlightById(Long flightId);
	public void deleteFlightById(Long flightId);
	public List<Flight> findAllFlights();

}
