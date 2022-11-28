package com.alexnikiforov.rma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VacancyDto {

    private String id;

    private String company;

    @JsonProperty("position_name")
    private String positionName;

    private String description;

    private String salary;

    @JsonProperty("salary_currency")
    private String salaryCurrency;

}
