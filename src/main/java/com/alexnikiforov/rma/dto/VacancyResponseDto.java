package com.alexnikiforov.rma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacancyResponseDto {

    private Long id;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("position_name")
    private String positionName;

    private String description;

    private Integer salary;

    @JsonProperty("salary_currency")
    private String salaryCurrency;
}
