package com.fazenda.dto;

import java.time.LocalDate;

import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.Vacina;

public class NovaVacinaDTO {

	private Long vacinaId;
	private LocalDate data;

	public NovaVacinaDTO() {

	}

	public NovaVacinaDTO(Vacina vacina, AnimalVacina data) {
		this.vacinaId = vacina.getId();
		this.data = data.getData();
	}

	public Long getVacinaId() {
		return vacinaId;
	}

	public void setVacinaId(Long vacinaId) {
		this.vacinaId = vacinaId;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
