package com.fazenda.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AnimalVacinaFK {

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id")
	private Vacina vac;
	
	public AnimalVacinaFK() {
		
	}

	public AnimalVacinaFK(Animal animal, Vacina vacina) {
		this.animal = animal;
		this.vac = vacina;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Vacina getVac() {
		return vac;
	}

	public void setVac(Vacina vacina) {
		this.vac = vacina;
	}
	
	
	
}
