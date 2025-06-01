package com.fazenda.dto;

import java.util.List;

import com.fazenda.entities.Vacina;

public class VacinaDTO {
	
	private String vacina;
	private Long id;
	
	public VacinaDTO() {
		
	}
	
	public VacinaDTO(Vacina vacina) {
		this.id = vacina.getId();
		this.vacina = vacina.getVacina();
	}
	
	public VacinaDTO(String vacina) {
        this.vacina = vacina;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}


	
	
}
