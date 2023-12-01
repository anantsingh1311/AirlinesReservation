package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Airport;
import com.synergisticit.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	AirportRepository airportRepository;
	@Override
	public Airport SaveAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Airport findAirportbyId(Long aiportId) {
		Optional<Airport> airport= airportRepository.findById(aiportId);
		
		if(airport.isPresent()) {
			return airport.get();
		}
		return null;
	}

	@Override
	public void deleteAirportById(Long aiportId) {
		airportRepository.deleteById(aiportId);
		
	}

	@Override
	public List<Airport> findAllAiports() {
		return airportRepository.findAll();
	}

}
