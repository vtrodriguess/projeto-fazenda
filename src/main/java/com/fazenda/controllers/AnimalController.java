package com.fazenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.dto.AnimalDTO;
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
	
}
