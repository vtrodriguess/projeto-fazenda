package com.fazenda.projections;

import java.util.List;

import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.Categoria;
import com.fazenda.entities.Raca;
import com.fazenda.enums.Sexo;

public interface AnimalRaca {
	
	Long getId();
	Raca getRaca();
    Categoria getCategoria();
    int getMeses();
	Sexo getSexo();
	double getPeso();
	List<AnimalVacina> getVacinas();

}
