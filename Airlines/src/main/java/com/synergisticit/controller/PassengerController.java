package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Flight;
import com.synergisticit.domain.Passenger;
import com.synergisticit.service.PassengerService;

import jakarta.validation.Valid;

@Controller
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;
	
	@RequestMapping("/passengerForm")
	public String passengerForm(Passenger passenger, Model model) {
		model.addAttribute("Passengers", passengerService.findAllPassenger());
		return "PassengerForm";
	}
	
	@RequestMapping("/savePassenger")
	public String SaveFlights(@Valid Passenger passenger, Model model) {
		
		passengerService.savePassenger(passenger);
		model.addAttribute("Passengers", passengerService.findAllPassenger());
		return"PassengerForm";
	}
	

}
