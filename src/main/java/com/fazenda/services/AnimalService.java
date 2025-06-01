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
import com.fazenda.entities.Categoria;
import com.fazenda.entities.Raca;
import com.fazenda.entities.Vacina;
import com.fazenda.enums.Sexo;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.AnimalVacinaRepository;
import com.fazenda.repositories.CategoriaRepository;
import com.fazenda.repositories.RacaRepository;
import com.fazenda.repositories.VacinaRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;

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
	public Animal cadastrarAnimal(Long idRaca, Long idCategoria, Sexo sexo, int meses, double peso) {
		Animal addAnimal = new Animal();
		Raca raca = racaRepository.findById(idRaca).get();
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		
		addAnimal.setCategoria(categoria);
		addAnimal.setRaca(raca);
		addAnimal.setSexo(sexo);
		addAnimal.setPeso(peso);
		addAnimal.setMeses(meses);
		
		return animalRepository.save(addAnimal);
	}

	@Transactional
	public Animal atualizaAnimal(Long id, Long idCategoria, int meses, double peso) {
		Animal attAnimal = animalRepository.findById(id).get();
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		attAnimal.setMeses(meses);
		attAnimal.setPeso(peso);
		attAnimal.setCategoria(categoria);

		return animalRepository.save(attAnimal);
	}

	@Transactional
	public void deleteById(Long id) {
		animalRepository.deleteById(id);
	}
}
