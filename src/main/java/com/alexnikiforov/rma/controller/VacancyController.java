package com.alexnikiforov.rma.controller;

import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.VacancyDto;
import com.alexnikiforov.rma.services.VacancyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vacancy")
@Slf4j
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<Vacancy> addVacancy(@RequestBody VacancyDto vacancyDto) {
        //TODO add validation
        Vacancy vacancy = vacancyService.addVacancy(vacancyDto);
        return ResponseEntity.ok().body(vacancy);

    }

}
