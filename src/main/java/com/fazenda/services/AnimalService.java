package com.fazenda.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.dto.AnimalDTO;
import com.fazenda.dto.AnimalRacaDTO;
import com.fazenda.dto.AnimalVacinaDTO;
import com.fazenda.entities.Animal;
import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.AnimalVacinaId;
import com.fazenda.entities.Vacina;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.AnimalVacinaRepository;
import com.fazenda.repositories.VacinaRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Transactional(readOnly = true)
	public List<AnimalDTO> findAll() {
		List<Animal> animal = animalRepository.findAll();
		return animal.stream().map(x -> new AnimalDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public AnimalDTO findById(Long id) {
		Animal animal = animalRepository.findById(id).get();
		return new AnimalDTO(animal);

	}

	@Transactional(readOnly = true)
	public List<AnimalRacaDTO> findByRaca(String raca) {
		List<Animal> animal = animalRepository.findByRaca(raca);
		return animal.stream().map(x -> new AnimalRacaDTO(x)).toList();

	}
	
	@Transactional
	public Animal updateAnimal (Long id, Animal animal) {
		Animal attAnimal = animalRepository.findById(id).get();
		attAnimal.setMeses(animal.getMeses());
		attAnimal.setPeso(animal.getPeso());
		attAnimal.setCategoria(animal.getCategoria());
		
		return animalRepository.save(attAnimal);
	}
	

	@Transactional
	public void deleteById(Long id) {
		animalRepository.deleteById(id);
	}
}
