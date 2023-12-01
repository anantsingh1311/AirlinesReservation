package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Reservation;
import com.synergisticit.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation findReservationById(Long reservationId) {
	Optional<Reservation> reservations	= reservationRepository.findById(reservationId);
	if(reservations.isEmpty()) {
		return reservations.get();
	}
	return null;
	
	
	}

	@Override
	public void deleteReservationById(Long reservation) {
		reservationRepository.deleteById(reservation);
		
	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservationRepository.findAll();
	}

}
