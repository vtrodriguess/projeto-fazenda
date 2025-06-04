package com.fazenda.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.dto.AnimalVacinaDTO;
import com.fazenda.dto.VacinaDTO;
import com.fazenda.entities.Animal;
import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.AnimalVacinaId;
import com.fazenda.entities.Categoria;
import com.fazenda.entities.Raca;
import com.fazenda.entities.Vacina;
import com.fazenda.enums.Sexo;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.AnimalVacinaRepository;
import com.fazenda.repositories.CategoriaRepository;
import com.fazenda.repositories.RacaRepository;
import com.fazenda.repositories.VacinaRepository;

@Service
public class VacinaService {
	
	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private VacinaRepository vacinaRepository;

	@Autowired
	private AnimalVacinaRepository animalVacinaRepository;
	

	
	@Transactional(readOnly = true)
	public List<Vacina> findAll() {
		return vacinaRepository.findAll();
	}

	@Transactional
	public AnimalVacina novaVacina(Long idAnimal, Long idVacina, LocalDate dataVacina) {
		Animal animal = animalRepository.findById(idAnimal).get();
		Vacina vacina = vacinaRepository.findById(idVacina).get();

		AnimalVacinaId avId = new AnimalVacinaId(animal, vacina);
		AnimalVacina av = new AnimalVacina();
		av.setId(avId);
		av.setData(dataVacina);

		return animalVacinaRepository.save(av);
	}
	
	@Transactional
	public Vacina criarVacina(String vacina) {
		Vacina vac = new Vacina();
		vac.setVacina(vacina);
		
		return vacinaRepository.save(vac);
	}

}
