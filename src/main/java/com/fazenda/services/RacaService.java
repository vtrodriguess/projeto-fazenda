package com.fazenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.dto.AnimalDTO;
import com.fazenda.dto.RacaDTO;
import com.fazenda.entities.Raca;
import com.fazenda.repositories.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Transactional(readOnly = true)
	public List<RacaDTO> findAll(){
		List<Raca> raca = racaRepository.findAll();
		return raca.stream().map(x -> new RacaDTO (x)).toList();
	}
	
	@Transactional(readOnly = true)
	public RacaDTO findById(Long id) {
		Raca raca = racaRepository.findById(id).get();
		return new RacaDTO(raca);
		
	}

}
