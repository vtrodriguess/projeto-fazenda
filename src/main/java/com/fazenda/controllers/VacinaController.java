package com.fazenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.dto.AnimalVacinaDTO;
import com.fazenda.dto.NovaVacinaDTO;
import com.fazenda.dto.VacinaDTO;
import com.fazenda.services.VacinaService;

@RestController
@RequestMapping (value = "/vacinas")
public class VacinaController {
	
	@Autowired
	private VacinaService vacinaService;
	
	@GetMapping
		public List<VacinaDTO> findByAll(){
			return vacinaService.findAll();
		}
	
	
	@PostMapping(value = "/vacinar/{id}")
	public ResponseEntity<AnimalVacinaDTO> novaVacina(@PathVariable Long id, @RequestBody NovaVacinaDTO novaVacina) {
		AnimalVacinaDTO animal = vacinaService.novaVacina(id, novaVacina.getVacinaId(), novaVacina.getData());
		
		return ResponseEntity.ok(animal);
	}

}
