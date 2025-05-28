package com.fazenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.entities.Animal;
import com.fazenda.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Transactional(readOnly = true)
	public List<Animal> findAll(){
		return animalRepository.findAll();
	}
}
