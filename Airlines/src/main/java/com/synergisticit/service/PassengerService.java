package com.synergisticit.service;

import java.util.List;


import com.synergisticit.domain.Passenger;

public interface PassengerService {
	public Passenger savePassenger(Passenger passenger);
	public Passenger findPassengerById(Long passengerId);
	public void deletePassengerById(Long passengerId);
	public List<Passenger> findAllPassenger();
}
