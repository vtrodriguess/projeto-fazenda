package com.fazenda.dto;

import java.util.List;

import com.fazenda.entities.Vacina;

public class VacinaDTO {
	
	private String vacina;
	
	public VacinaDTO(Vacina vacina) {
		this.vacina = vacina.getVacina();
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	
	
}
