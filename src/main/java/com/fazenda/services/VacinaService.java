package com.fazenda.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazenda.entities.Animal;
import com.fazenda.entities.AnimalVacina;
import com.fazenda.entities.AnimalVacinaId;
import com.fazenda.entities.Vacina;
import com.fazenda.repositories.AnimalRepository;
import com.fazenda.repositories.AnimalVacinaRepository;
import com.fazenda.repositories.VacinaRepository;

@Service
public class VacinaService {

	private AnimalRepository animalRepository;
	private VacinaRepository vacinaRepository;
	private AnimalVacinaRepository animalVacinaRepository;
	
	public VacinaService(AnimalRepository animalRepository, VacinaRepository vacinaRepository, AnimalVacinaRepository animalVacinaRepository) {
		this.animalRepository = animalRepository;
		this.vacinaRepository = vacinaRepository;
		this.animalVacinaRepository = animalVacinaRepository;
	}

	@Transactional(readOnly = true)
	public List<Vacina> findAll() {
		return vacinaRepository.findAll();
	}

	@Transactional
	public Optional<AnimalVacina> novaVacina(Long idAnimal, Long idVacina, LocalDate dataVacina) {
		Optional<Animal> animal = animalRepository.findById(idAnimal);
		Optional<Vacina> vacina = vacinaRepository.findById(idVacina);

		if (animal.isPresent() && vacina.isPresent()) {
			AnimalVacinaId avId = new AnimalVacinaId(animal.get(), vacina.get());
			AnimalVacina av = new AnimalVacina();
			av.setId(avId);
			av.setData(dataVacina);
			
			AnimalVacina cadastro = animalVacinaRepository.save(av);
			
			return Optional.of(cadastro);

		}

		return Optional.empty();
	}

	@Transactional
	public Vacina criarVacina(String vacina) {
		Vacina vac = new Vacina();
		vac.setVacina(vacina);

		return vacinaRepository.save(vac);
	}

}
