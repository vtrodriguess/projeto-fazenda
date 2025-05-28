package com.fazenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazenda.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
