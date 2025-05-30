package com.fazenda.dto;

import java.time.LocalDate;

import com.fazenda.entities.AnimalVacina;

public class AnimalVacinaDTO {
	
	private Long vacinaId;
    private String vacinaNome;
    private LocalDate data;
    
    public AnimalVacinaDTO() {
    	
    }

    public AnimalVacinaDTO(AnimalVacina av) {
        this.vacinaId = av.getId().getVacina().getId();
        this.vacinaNome = av.getId().getVacina().getVacina();
        this.data = av.getData();
    }

	public Long getVacinaId() {
		return vacinaId;
	}

	public void setVacinaId(Long vacinaId) {
		this.vacinaId = vacinaId;
	}

	public String getVacinaNome() {
		return vacinaNome;
	}

	public void setVacinaNome(String vacinaNome) {
		this.vacinaNome = vacinaNome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
    
    

}
