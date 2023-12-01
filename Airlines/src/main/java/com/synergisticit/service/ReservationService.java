package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Reservation;

public interface ReservationService {
	
	public Reservation saveReservation(Reservation reservation);
	public Reservation findReservationById(Long reservationId);
	public void deleteReservationById(Long reservation);
	public List<Reservation> findAllReservations();

}
