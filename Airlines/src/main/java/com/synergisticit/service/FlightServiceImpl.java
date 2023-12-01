package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Flight;
import com.synergisticit.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightRepository flightRepository;
	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
		
	}

	@Override
	public Flight findFlightById(Long flightId) {

		Optional<Flight> flights = flightRepository.findById(flightId);
		
		if(flights.isPresent()) {
			return flights.get();
		}
		
		return null;
		

		
	}

	@Override
	public void deleteFlightById(Long flightId) {
		flightRepository.deleteById(flightId);
		
	}

	@Override
	public List<Flight> findAllFlights() {
		return flightRepository.findAll();
	}
	
	

}
