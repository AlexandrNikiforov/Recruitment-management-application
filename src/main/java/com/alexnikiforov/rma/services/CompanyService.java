package com.alexnikiforov.rma.services;

import com.alexnikiforov.rma.domain.Company;
import com.alexnikiforov.rma.dto.CompanyRequestDto;
import com.alexnikiforov.rma.dto.CompanyResponseDto;
import com.alexnikiforov.rma.exception.CompanyException;
import com.alexnikiforov.rma.repositories.CompanyRepository;
import com.alexnikiforov.rma.util.DtoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponseDto addCompany(CompanyRequestDto companyRequestDto) {
        log.info("Add company: {}", companyRequestDto);

        //TODO think how to avoid throwing an exception
        if (companyRepository.existsByName(companyRequestDto.getName())) {
            log.debug("Company {} already exist", companyRequestDto);
            throw new CompanyException("Company " + companyRequestDto.getName() + " already exist");
        }

        try {
            return Optional.of(companyRepository.save(DtoUtil.toCompanyEntity(companyRequestDto)))
                    .map(DtoUtil::toCompanyResponseDto)
                    .orElseThrow(() -> new CompanyException("Error while adding a new company"));
        } catch (Exception e) {
            log.error("Error while adding company: {}", companyRequestDto);
            throw new CompanyException("Error while adding a company", e);
        }
    }

    public List<Company> getAll() {
        log.info("Get all companies");
        return companyRepository.findAll();
    }

    public Company getById(Long id) {
        log.info("Get company by id : {}", id);
        return companyRepository.findById(id)
                .orElseThrow();
    }

    public void deleteById(Long id) {
        log.info("Delete company with id: {}", id);
        companyRepository.deleteById(id);
    }
}
