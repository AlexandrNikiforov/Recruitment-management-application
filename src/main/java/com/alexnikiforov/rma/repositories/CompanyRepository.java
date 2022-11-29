package com.alexnikiforov.rma.repositories;

import com.alexnikiforov.rma.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    /*
    Derived query prefixes:
    find..By, get..By, read..By, query..By, search..By, stream..By,
    exist..By, count..By

    Query Modifiers (between "find" and "By"):
    - ..Distinct..
    - ..First<number>../..Top<number>..

    Use not more than one JOIN and not more than three bind parameters

    Connect Where parameters (after the word "By" with words "And" and "Or"
     */

    Company findByName(String name);

    boolean existsByName(String name);
}
