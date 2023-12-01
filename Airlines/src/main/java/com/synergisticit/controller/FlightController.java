package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Flight;
import com.synergisticit.service.FlightService;

import jakarta.validation.Valid;

@Controller
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping("/flightForm")
	public String FlightsForm(Flight flight, Model model) {
		
		model.addAttribute("flightList", flightService.findAllFlights());
		return "FlightForm";
	}
	
	@RequestMapping("/saveFlight")
	public String SaveFlights(@Valid Flight flight, Model model) {
		
		flightService.saveFlight(flight);
		model.addAttribute("flightList", flightService.findAllFlights());
		return"FlightForm";
	}

}
