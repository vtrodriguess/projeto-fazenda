package com.fazenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<AnimalDTO> findAll(){
		return animalService.findAll();
	}
	
	@PostMapping(value = "/cadastrar")
	public AnimalDTO cadastrarAnimal(@RequestBody CadastraAnimalDTO dto) {
		Animal animal = animalService.cadastrarAnimal(dto.getIdRaca(), dto.getIdCategoria(), dto.getSexo(), dto.getMeses(), dto.getPeso());
		
		return new AnimalDTO(animal);
	}
	
	@GetMapping(value = "/raca/{raca}")
	public List<AnimalRacaDTO> findByRaca(@PathVariable String raca){
		return animalService.findByRaca(raca);
	}
	
	@GetMapping(value = "/{id}")
	public AnimalDTO findById(@PathVariable Long id) {
		return animalService.findById(id);
	}
	
	
	@PutMapping(value = "/{id}")
	public AnimalDTO atualizaAnimal (@PathVariable Long id, @RequestBody AtualizaAnimalDTO dto) {
		Animal animal = animalService.atualizaAnimal(id, dto.getIdCategoria(), dto.getMeses(), dto.getPeso());
		return new AnimalDTO(animal);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		 animalService.deleteById(id);
	}
	
}
