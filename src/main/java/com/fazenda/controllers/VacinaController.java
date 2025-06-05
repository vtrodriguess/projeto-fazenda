package com.fazenda.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
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
import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.Vacina;
import com.fazenda.services.VacinaService;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaController {

	private VacinaService vacinaService;
	
	public VacinaController(VacinaService vacinaService) {
		this.vacinaService = vacinaService;
	}

	@GetMapping
	public List<VacinaDTO> findByAll() {
		List <Vacina> vacina = vacinaService.findAll();
		
		return vacina.stream().map(x -> new VacinaDTO(x)).toList();
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<VacinaDTO> novaVacina(@RequestBody VacinaDTO vacina) {
		Vacina vac = vacinaService.criarVacina(vacina.getVacina());
		VacinaDTO dto = new VacinaDTO(vac);
		
		return ResponseEntity.ok().header("X-Mensagem", "Vacina criada").body(dto);
	}

	@PostMapping(value = "/vacinar/{id}")
	public ResponseEntity<AnimalVacinaDTO> novaVacina(@PathVariable Long id, @RequestBody NovaVacinaDTO novaVacina) {
		Optional <AnimalVacina> animal = vacinaService.novaVacina(id, novaVacina.getVacinaId(), novaVacina.getData());
		if(animal.isPresent()) {
			AnimalVacinaDTO dto = new AnimalVacinaDTO(animal.get());
			return ResponseEntity.ok().header("X-Mensagem", "Vacina adicionada ao animal").body(dto);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
