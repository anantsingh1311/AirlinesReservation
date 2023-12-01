package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Airlines;
import com.synergisticit.domain.Role;
import com.synergisticit.service.AirlinesService;

import jakarta.validation.Valid;



@Controller
public class AirlineController {
	
	@Autowired
	AirlinesService airlineService;

	@RequestMapping("/airlineForm")
	public String airLineForm(Airlines airlines, Model model) {
		
		model.addAttribute("airlinesList",airlineService.findAllAirlines());
		return "AirlineForm";
	}
	
	@RequestMapping("/saveAirlines")
	public String SaveAirlines(@Valid Airlines airlines,Model model) {
		airlineService.saveAirlines(airlines);
		 model.addAttribute("airlinesList", airlineService.findAllAirlines());
		 return "AirlineForm";
	}
	

}
