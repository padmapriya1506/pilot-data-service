package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.TaxExemptions;

public interface TaxExemptionRepository extends JpaRepository<TaxExemptions, Long> {

}
