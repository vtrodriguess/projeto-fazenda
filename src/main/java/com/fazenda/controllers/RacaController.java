package com.fazenda.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.dto.RacaDTO;
import com.fazenda.entities.Raca;
import com.fazenda.services.RacaService;

@RequestMapping(value = "/racas")
@RestController
public class RacaController {

	private RacaService racaService;
	
	public RacaController (RacaService racaService) {
		this.racaService = racaService;
	}
	
	@GetMapping
	public List<RacaDTO> findAll(){
		List <Raca> raca = racaService.findAll();
		return raca.stream().map(x -> new RacaDTO(x)).toList();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <RacaDTO> findById(@PathVariable Long id) {
		Optional <Raca> raca = racaService.findById(id);
		RacaDTO dto = new RacaDTO(raca.get());
		
		return ResponseEntity.ok(dto);
	}

}
