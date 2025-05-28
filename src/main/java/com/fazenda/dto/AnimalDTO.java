package com.fazenda.dto;

import java.util.List;

import com.fazenda.entities.Animal;
import com.fazenda.entities.Categoria;
import com.fazenda.enums.Sexo;

public class AnimalDTO {
	
	private Long id;
    private int idade;
	private Sexo sexo;
	private RacaDTO racaDTO;
	private CategoriaDTO categoriaDTO;
	private double peso;
	private List<VacinaDTO> vacinas;
	
	public AnimalDTO(Animal animal) {
		this.id = animal.getId();
		this.idade = animal.getIdade();
		this.sexo = animal.getSexo();
		this.racaDTO = new RacaDTO(animal.getRaca());
		this.categoriaDTO = new CategoriaDTO(animal.getCategoria());
		this.peso = animal.getPeso();
		this.vacinas = animal.getVacinas().stream().map(x -> new VacinaDTO(x)).toList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public RacaDTO getRacaDTO() {
		return racaDTO;
	}

	public void setRacaDTO(RacaDTO racaDTO) {
		this.racaDTO = racaDTO;
	}

	public CategoriaDTO  getCategoriaDTO() {
		return categoriaDTO ;
	}

	public void setCategoriaDTO (CategoriaDTO  categoriaDTO )  {
		this.categoriaDTO  = categoriaDTO ;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

}
