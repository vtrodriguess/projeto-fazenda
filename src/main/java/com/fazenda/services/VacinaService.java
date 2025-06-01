package com.fazenda.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.dto.AnimalDTO;
import com.fazenda.dto.AnimalVacinaDTO;
import com.fazenda.dto.VacinaDTO;
import com.fazenda.entities.Animal;
import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.AnimalVacinaId;
import com.fazenda.entities.Vacina;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.AnimalVacinaRepository;
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
	public List<VacinaDTO> findAll() {
		List<Vacina> vacina = vacinaRepository.findAll();
		return vacina.stream().map(x -> new VacinaDTO(x)).toList();
	}

	@Transactional
	public AnimalVacinaDTO novaVacina(Long idAnimal, Long idVacina, LocalDate dataVacina) {
		Animal animal = animalRepository.findById(idAnimal).get();
		Vacina vacina = vacinaRepository.findById(idVacina).get();

		AnimalVacinaId avId = new AnimalVacinaId(animal, vacina);
		AnimalVacina av = new AnimalVacina();
		av.setId(avId);
		av.setData(dataVacina);

		return new AnimalVacinaDTO(animalVacinaRepository.save(av));
	}
	
	@Transactional
	public VacinaDTO criarVacina(String vacina) {
		Vacina vac = new Vacina();
		vac.setVacina(vacina);
		
		return new VacinaDTO(vacinaRepository.save(vac));
	}

}
