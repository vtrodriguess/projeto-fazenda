package com.fazenda.dto;


public class AtualizaAnimalDTO {

	private Long idCategoria;
	private int meses;
	private double peso;
	
	public AtualizaAnimalDTO() {
		
	}

	public AtualizaAnimalDTO(Long idCategoria, int meses, double peso) {
		this.idCategoria = idCategoria;
		this.meses = meses;
		this.peso = peso;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
