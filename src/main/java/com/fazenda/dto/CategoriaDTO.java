package com.fazenda.dto;

import com.fazenda.entities.Categoria;

public class CategoriaDTO {

	private String categoria;
	
	public CategoriaDTO(Categoria entity) {
		this.categoria = entity.getCategoria();
	}
}
