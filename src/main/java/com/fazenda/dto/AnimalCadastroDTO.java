package com.fazenda.dto;

import com.fazenda.entities.Categoria;
import com.fazenda.entities.Raca;
import com.fazenda.enums.Sexo;

public class AnimalCadastroDTO {
	
	private Long idRaca;
	private Long idCategoria;
	private Sexo sexo;
	private int meses;
	private double peso;
	
	public AnimalCadastroDTO() {
		
	}

	public AnimalCadastroDTO(Raca idRaca, Categoria idCategoria, Sexo sexo, int meses, double peso) {
		this.idRaca = idRaca.getId();
		this.idCategoria = idCategoria.getId();
		this.sexo = sexo;
		this.meses = meses;
		this.peso = peso;
	}

	public Long getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
