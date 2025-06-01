package com.fazenda.entities;

import java.util.ArrayList;
import java.util.List;

import com.fazenda.enums.Sexo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int meses;
	
	@OneToMany(mappedBy = "id.animal", cascade = CascadeType.REMOVE)
	private List<AnimalVacina> vacinas = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name = "raca_fk")
	private Raca raca;
	
	@ManyToOne
	@JoinColumn(name = "categoria_fk")
	private Categoria categoria;
	

	private double peso;
	
	public Animal() {
		
	}

	public Animal(Long id, int meses, Sexo sexo, Raca raca, Categoria categoria, double peso) {
		this.id = id;
		this.meses = meses;
		this.sexo = sexo;
		this.raca = raca;
		this.categoria = categoria;
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<AnimalVacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<AnimalVacina> vacinas) {
		this.vacinas = vacinas;
	}
	
	
	

}
