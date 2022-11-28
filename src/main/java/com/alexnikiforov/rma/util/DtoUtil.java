package com.alexnikiforov.rma.util;

import com.alexnikiforov.rma.domain.Vacancy;
import com.alexnikiforov.rma.dto.VacancyDto;
import org.springframework.web.bind.annotation.RequestBody;

public class DtoUtil {

    public static Vacancy toVacancyEntity(@RequestBody VacancyDto vacancyDto) {
        return new Vacancy(vacancyDto.getCompany(),
                vacancyDto.getPositionName(),
                vacancyDto.getDescription(),
                Integer.valueOf(vacancyDto.getSalary()),
                vacancyDto.getSalaryCurrency());
    }
}
