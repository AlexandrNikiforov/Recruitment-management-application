package com.alexnikiforov.rma.services;

import com.alexnikiforov.rma.domain.Company;
import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.domain.VacancyState;
import com.alexnikiforov.rma.dto.VacancyRequestDto;
import com.alexnikiforov.rma.dto.VacancyResponseDto;
import com.alexnikiforov.rma.exception.VacancyException;
import com.alexnikiforov.rma.repositories.CompanyRepository;
import com.alexnikiforov.rma.repositories.VacancyRepository;
import com.alexnikiforov.rma.util.DtoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final CompanyRepository companyRepository;

    public VacancyResponseDto addVacancy(VacancyRequestDto vacancyRequestDto) {
        log.info("Add vacancy : {}", vacancyRequestDto);
        if (!companyRepository.existsByName(vacancyRequestDto.getCompanyName())) {
            log.error("Company specified in a vacancy doesn't exist");
            throw new VacancyException("Company specified in a vacancy doesn't exist");
        } else {
            try {
                Company companyEntity = companyRepository.findByName(vacancyRequestDto.getCompanyName());

                return Optional.ofNullable(companyEntity)
                        .map(company -> vacancyRepository.save(DtoUtil.toVacancyEntity(vacancyRequestDto, company,
                                VacancyState.NOT_ASSIGNED)))
                        .map(DtoUtil::toVacancyResponseDto)
                        .orElseThrow(() -> new VacancyException("Error when adding a new Vacancy"));
            } catch (Exception e) {
                log.error("Error while adding a new vacancy");
                throw new VacancyException("Error while adding a new vacancy");
            }
        }
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
