package com.alexnikiforov.rma.util;

import com.alexnikiforov.rma.domain.Company;
import com.alexnikiforov.rma.domain.Experience;
import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.CompanyRequestDto;
import com.alexnikiforov.rma.dto.CompanyResponseDto;
import com.alexnikiforov.rma.dto.VacancyRequestDto;
import com.alexnikiforov.rma.dto.VacancyResponseDto;

public class DtoUtil {

    public static Vacancy toVacancyEntity(VacancyRequestDto vacancyRequestDto, Company company) {
        return new Vacancy(
                Experience.valueOf(vacancyRequestDto.getRequiredExperience()),
                company,
                vacancyRequestDto.getPositionName(),
                vacancyRequestDto.getDescription(),
                Integer.valueOf(vacancyRequestDto.getSalary()),
                vacancyRequestDto.getSalaryCurrency());
    }

    public static Company toCompanyEntity(CompanyRequestDto companyRequestDto) {
        return new Company(companyRequestDto.getName(), companyRequestDto.getDescription());
    }

    public static VacancyResponseDto toVacancyResponseDto(Vacancy vacancy) {
        return VacancyResponseDto.builder()
                .id(vacancy.getId())
                .requiredExperience(vacancy.getRequiredExperience().name())
                .companyName(vacancy.getCompany().getName())
                .positionName(vacancy.getPositionName())
                .positionName(vacancy.getPositionName())
                .description(vacancy.getDescription())
                .salary(vacancy.getSalary())
                .salaryCurrency(vacancy.getSalaryCurrency())
                .build();
    }

    public static CompanyResponseDto toCompanyResponseDto(Company company) {
        return CompanyResponseDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .build();

    }
}
