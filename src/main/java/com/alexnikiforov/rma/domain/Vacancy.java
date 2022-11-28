package com.alexnikiforov.rma.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vacancy {

    public Vacancy(String company, String positionName, String description, Integer salary, String salaryCurrency) {
        this.company = company;
        this.positionName = positionName;
        this.description = description;
        this.salary = salary;
        this.salaryCurrency = salaryCurrency;
    }

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacancy_seq")
    @SequenceGenerator(name = "vacancy_seq")
    private Long id;

    private String company;

    @Column(name = "position_name")
    private String positionName;

    private String description;

    private Integer salary;

    @Column(name = "salary_currency")
    private String salaryCurrency;

}
