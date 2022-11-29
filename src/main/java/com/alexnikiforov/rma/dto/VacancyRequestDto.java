package com.alexnikiforov.rma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VacancyRequestDto {

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("position_name")
    private String positionName;

    private String description;

    private String salary;

    @JsonProperty("salary_currency")
    private String salaryCurrency;

}
