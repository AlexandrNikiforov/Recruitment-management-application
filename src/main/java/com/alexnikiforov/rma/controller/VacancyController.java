package com.alexnikiforov.rma.controller;

import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.VacancyDto;
import com.alexnikiforov.rma.services.VacancyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vacancies")
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

    @GetMapping
    public ResponseEntity<List<Vacancy>> getVacancies() {
        List<Vacancy> vacancies = vacancyService.getAll();
        return ResponseEntity.ok().body(vacancies);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable("id") Long id) {
        Vacancy vacancy = vacancyService.getById(id);
        return ResponseEntity.ok().body(vacancy);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteVacancyById(@PathVariable("id") Long id) {
        vacancyService.deleteById(id);
        return ResponseEntity.ok().body("Deleted vacancy with id = " + id);
    }

}
