package com.fazenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.dto.RacaDTO;
import com.fazenda.services.RacaService;

@RequestMapping(value = "/racas")
@RestController
public class RacaController {
	
	@Autowired
	private RacaService racaService;
	
	@GetMapping
	public List<RacaDTO> findAll(){
		return racaService.findAll();
	}

}
