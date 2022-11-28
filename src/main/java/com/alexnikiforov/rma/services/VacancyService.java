package com.alexnikiforov.rma.services;

import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.VacancyDto;
import com.alexnikiforov.rma.repositories.VacancyRepository;
import com.alexnikiforov.rma.util.DtoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public Vacancy addVacancy(VacancyDto vacancyDto) {
        log.info("Add vacancy : {}", vacancyDto);
        return vacancyRepository.save(DtoUtil.toVacancyEntity(vacancyDto));
    }

}
