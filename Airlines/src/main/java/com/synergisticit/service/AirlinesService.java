package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Airlines;

public interface AirlinesService {
	
	public Airlines saveAirlines(Airlines airlines);
	public Airlines findByAirlineId(Long airlinesId);
	public void deleteAirlinesById(Long airlinesId);
	public List<Airlines> findAllAirlines();

}
