package com.fazenda.dto;

import com.fazenda.entities.Raca;

public class RacaDTO {
	
	private String raca;
	private String tipo;
	
	public RacaDTO() {
		
	}
	
	public RacaDTO(Raca entity) {
		this.raca = entity.getRaca();
		this.tipo = entity.getTipo();
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
