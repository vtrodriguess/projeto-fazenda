package com.fazenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazenda.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
