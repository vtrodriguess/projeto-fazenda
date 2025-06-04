package com.fazenda.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.dto.AnimalDTO;
import com.fazenda.dto.AnimalRacaDTO;
import com.fazenda.dto.AtualizaAnimalDTO;
import com.fazenda.dto.CadastraAnimalDTO;
import com.fazenda.entities.Animal;
import com.fazenda.services.AnimalService;

@RestController
@RequestMapping(value = "/animais")
public class AnimalController {

	@Autowired
	
	private AnimalService animalService;

	@GetMapping
	public ResponseEntity<List<AnimalDTO>> findAll() {
		return ResponseEntity.ok(animalService.findAll());
	}

	@GetMapping(value = "/raca/{id}")
	public ResponseEntity <List<AnimalRacaDTO>> findByRaca(@PathVariable Long id) {
		return ResponseEntity.ok(animalService.findByRaca(id));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AnimalDTO> findById(@PathVariable Long id) {
		Optional<Animal> animal = animalService.findById(id);
		
		AnimalDTO dto = new AnimalDTO(animal.get());
		
		return ResponseEntity.ok(dto);
	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<AnimalDTO> cadastrarAnimal(@RequestBody CadastraAnimalDTO dto) {
		Optional<Animal> animal = animalService.cadastrarAnimal(dto.getIdRaca(), dto.getIdCategoria(), dto.getSexo(),
				dto.getMeses(), dto.getPeso());

		AnimalDTO animalDTO = new AnimalDTO(animal.get());

		return ResponseEntity.status(HttpStatus.CREATED)
								.header("X-Cadastro", "Animal cadastrado!")
								.body(animalDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AnimalDTO> atualizaAnimal(@PathVariable Long id, @RequestBody AtualizaAnimalDTO dto) {
		animalService.atualizaAnimal(id, dto.getIdCategoria(), dto.getMeses(), dto.getPeso());
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		animalService.deleteById(id);
	}

}
