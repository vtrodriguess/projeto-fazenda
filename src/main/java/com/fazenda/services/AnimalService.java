package com.fazenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.dto.AnimalDTO;
import com.fazenda.dto.AnimalRacaDTO;
import com.fazenda.entities.Animal;
import com.fazenda.entities.Categoria;
import com.fazenda.entities.Raca;
import com.fazenda.enums.Sexo;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.CategoriaRepository;
import com.fazenda.repositories.RacaRepository;

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
		return animalRepository.findAll().stream().map(x -> new AnimalDTO(x)).toList();
	
	}

	@Transactional(readOnly = true)
	public Optional<Animal> findById(Long id) {
		return animalRepository.findById(id);

	}

	@Transactional(readOnly = true)
	public List<AnimalRacaDTO> findByRaca(Long id) {
		List<Animal> animal = animalRepository.findByRaca(id);
		return animal.stream().map(x -> new AnimalRacaDTO(x)).toList();

	}

	@Transactional
	public Optional<Animal> cadastrarAnimal(Long idRaca, Long idCategoria, Sexo sexo, int meses, double peso) {
		Optional<Raca> raca = racaRepository.findById(idRaca);
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

		if (raca.isPresent() && categoria.isPresent()) {
			Animal addAnimal = new Animal();
			addAnimal.setCategoria(categoria.get());
			addAnimal.setRaca(raca.get());
			addAnimal.setSexo(sexo);
			addAnimal.setPeso(peso);
			addAnimal.setMeses(meses);
			
			Animal cadastrado = animalRepository.save(addAnimal);
			
			return Optional.of(cadastrado);
		}

		return Optional.empty();
	}

	@Transactional
	public Optional<Animal> atualizaAnimal(Long id, Long idCategoria, int meses, double peso) {
		Optional<Animal> attAnimal = animalRepository.findById(id);
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

		if (attAnimal.isPresent() && categoria.isPresent()) {
			Animal animal = attAnimal.get();
			animal.setMeses(meses);
			animal.setPeso(peso);
			animal.setCategoria(categoria.get());

			Animal atualizado = animalRepository.save(animal);
			return Optional.of(atualizado);
		}

		return Optional.empty();
	}

	@Transactional
	public void deleteById(Long id) {
		if(!animalRepository.existsById(id)) {
			throw new RuntimeException("Não existe o animal com o id " + id);
		}
		animalRepository.deleteById(id);
	}
}
