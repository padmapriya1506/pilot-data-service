package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.CompanyAddress;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, Long> {

}
