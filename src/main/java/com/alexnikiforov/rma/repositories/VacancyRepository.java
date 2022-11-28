package com.alexnikiforov.rma.repositories;

import com.alexnikiforov.rma.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
