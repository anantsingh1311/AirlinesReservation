package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.synergisticit.domain.Airport;
import com.synergisticit.service.AirportService;

import jakarta.validation.Valid;

@Controller
public class AirportController {

	@Autowired
	AirportService airportService;

	@RequestMapping("/airportForm")
	public String AirportForm(Airport airport, Model model) {

		model.addAttribute("aiports", airportService.findAllAiports());
		return "AirportForm";

	}

	@RequestMapping("/saveAirport")
	public String SaveAirport(@Valid Airport airport, Model model) {
		airportService.SaveAirport(airport);
		model.addAttribute("airports", airportService.findAllAiports());
		return "AirportForm";
	}
}