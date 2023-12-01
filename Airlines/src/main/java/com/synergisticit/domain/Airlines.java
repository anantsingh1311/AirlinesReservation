package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airlines {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long airlinesId;
	private String airlinesName;
	private String airlinesCode;
	
	@OneToMany
	private List<Flight> flights = new ArrayList<>();

}
