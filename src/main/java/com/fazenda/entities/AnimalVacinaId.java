package com.fazenda.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AnimalVacinaId {

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id")
	private Vacina vac;
	
	public AnimalVacinaId() {
		
	}

	public AnimalVacinaId(Animal animal, Vacina vacina) {
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

	@Override
	public int hashCode() {
		return Objects.hash(animal, vac);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalVacinaId other = (AnimalVacinaId) obj;
		return Objects.equals(animal, other.animal) && Objects.equals(vac, other.vac);
	}
	
	
	
}
