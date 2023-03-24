package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {

}
