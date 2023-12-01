package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Airport;

public interface AirportService {
	
	public Airport SaveAirport(Airport airport);
	public Airport findAirportbyId(Long aiportId);
	public void deleteAirportById(Long aiportId);
	public List<Airport> findAllAiports();
}
