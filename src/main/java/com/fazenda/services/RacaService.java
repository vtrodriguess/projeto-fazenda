package com.fazenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.entities.Raca;
import com.fazenda.repositories.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Transactional(readOnly = true)
	public List<Raca> findAll(){
		return racaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional <Raca> findById(Long id) {
		Optional <Raca> raca = racaRepository.findById(id);
		return raca;
		
	}

}
