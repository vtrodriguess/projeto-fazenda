package com.fazenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fazenda.entities.Animal;
import com.fazenda.projections.AnimalRaca;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query(value = """
			SELECT a FROM Animal a JOIN FETCH a.raca r LEFT JOIN FETCH a.vacinas v WHERE r.raca = :x""")
	List<Animal> findByRaca(@Param("x") String raca);

}
