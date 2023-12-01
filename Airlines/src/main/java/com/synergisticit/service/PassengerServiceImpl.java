package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Passenger;
import com.synergisticit.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public Passenger savePassenger(Passenger passenger) {
	
		return passengerRepository.save(passenger);
	}

	@Override
	public Passenger findPassengerById(Long passengerId) {
		Optional<Passenger> passengers = passengerRepository.findById(passengerId);
		
		if(passengers.isPresent()) {
			return passengers.get();
		}
		return null;
	}

	@Override
	public void deletePassengerById(Long passengerId) {
		passengerRepository.deleteById(passengerId);
	}

	@Override
	public List<Passenger> findAllPassenger() {
		return passengerRepository.findAll();
	}

}
