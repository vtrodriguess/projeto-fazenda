package com.fazenda.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_animal_vacina")
public class AnimalVacina {
	
	@EmbeddedId
	private AnimalVacinaId id = new AnimalVacinaId();
	
	@Column(name = "data_aplicacao")
	private LocalDate data;

	public AnimalVacina() {
		
	}

	public AnimalVacina(Animal animal, Vacina vacina, LocalDate data) {
		this.id.setAnimal(animal);
		this.id.setVac(vacina);
		this.data = data;
	}
	

	public AnimalVacinaId getId() {
		return id;
	}

	public void setId(AnimalVacinaId id) {
		this.id = id;
	}
	
	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalVacina other = (AnimalVacina) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
