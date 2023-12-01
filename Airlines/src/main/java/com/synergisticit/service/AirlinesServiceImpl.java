package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Airlines;
import com.synergisticit.repository.AirlinesRepository;

@Service
public class AirlinesServiceImpl implements AirlinesService{
	
	@Autowired
	AirlinesRepository airlinesRepository;

	@Override
	public Airlines saveAirlines(Airlines airlines) {
		
		return airlinesRepository.save(airlines);
	}

	@Override
	public Airlines findByAirlineId(Long airlinesId) {
		
		Optional<Airlines> airlines=airlinesRepository.findById(airlinesId);
		if(airlines.isPresent()) {
			return airlines.get();
		}
		
		
		return null;
	}

	@Override
	public void deleteAirlinesById(Long airlinesId) {
		airlinesRepository.deleteById(airlinesId);
		
	}

	@Override
	public List<Airlines> findAllAirlines() {
		 return airlinesRepository.findAll();
	}

}
