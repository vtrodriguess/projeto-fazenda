package com.fazenda.dto;

import com.fazenda.entities.Categoria;

public class CategoriaDTO {

	private String categoria;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria entity) {
		this.categoria = entity.getCategoria();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
