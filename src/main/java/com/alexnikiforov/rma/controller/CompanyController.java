package com.alexnikiforov.rma.controller;

import com.alexnikiforov.rma.domain.Company;
import com.alexnikiforov.rma.dto.CompanyRequestDto;
import com.alexnikiforov.rma.dto.CompanyResponseDto;
import com.alexnikiforov.rma.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
    
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponseDto> addVacancy(@RequestBody CompanyRequestDto companyRequestDto) {
        //TODO add validation
        CompanyResponseDto company = companyService.addCompany(companyRequestDto);
        return ResponseEntity.ok().body(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok().body(companies);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
        Company company = companyService.getById(id);
        return ResponseEntity.ok().body(company);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {
        companyService.deleteById(id);
        return ResponseEntity.ok().body("Deleted vacancy with id = " + id);
    }
}
