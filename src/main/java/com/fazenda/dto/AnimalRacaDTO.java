package com.fazenda.dto;

import java.util.List;

import com.fazenda.entities.Animal;
import com.fazenda.enums.Sexo;


public class AnimalRacaDTO {

	private Long id;
	private RacaDTO racaDTO;
	private CategoriaDTO categoriaDTO;
	private int meses;
	private Sexo sexo;
	private double peso;
	private List<AnimalVacinaDTO> vacinas;

	public AnimalRacaDTO(Animal animal) {
		this.id = animal.getId();
		this.meses = animal.getMeses();
		this.sexo = animal.getSexo();
		this.racaDTO = new RacaDTO(animal.getRaca());
		this.categoriaDTO = new CategoriaDTO(animal.getCategoria());
		this.peso = animal.getPeso();
		this.vacinas = animal.getVacinas().stream().map(x -> new AnimalVacinaDTO(x)).toList();
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

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public List<AnimalVacinaDTO> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<AnimalVacinaDTO> vacinas) {
		this.vacinas = vacinas;
	}
}
