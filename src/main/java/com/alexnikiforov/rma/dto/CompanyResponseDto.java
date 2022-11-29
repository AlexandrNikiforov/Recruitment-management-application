package com.alexnikiforov.rma.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponseDto {

    private Long id;

    private String name;

    private String description;
}
