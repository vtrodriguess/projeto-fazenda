package com.fazenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.AnimalVacinaId;

public interface AnimalVacinaRepository extends JpaRepository<AnimalVacina, AnimalVacinaId> {

}
