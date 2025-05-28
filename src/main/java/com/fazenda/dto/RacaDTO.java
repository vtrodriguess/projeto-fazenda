package com.fazenda.dto;

import com.fazenda.entities.Raca;

public class RacaDTO {
	
	private String raca;
	
	public RacaDTO(Raca entity) {
		this.raca = entity.getRaca();
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	
}
