package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.synergisticit.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;

	
	
}
