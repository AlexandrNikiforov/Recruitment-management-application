package com.alexnikiforov.rma.services;

import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.VacancyDto;
import com.alexnikiforov.rma.repositories.VacancyRepository;
import com.alexnikiforov.rma.util.DtoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public Vacancy addVacancy(VacancyDto vacancyDto) {
        log.info("Add vacancy : {}", vacancyDto);
        return vacancyRepository.save(DtoUtil.toVacancyEntity(vacancyDto));
    }

    public List<Vacancy> getAll() {
        log.info("Get all vacancies");
        return vacancyRepository.findAll();
    }

    public Vacancy getById(Long id) {
        log.info("Get vacancy by id : {}", id);
        return vacancyRepository.findById(id)
                .orElseThrow();
    }

    public void deleteById(Long id) {
        log.info("Delete vacancy with id: {}", id);
        vacancyRepository.deleteById(id);
    }
}
