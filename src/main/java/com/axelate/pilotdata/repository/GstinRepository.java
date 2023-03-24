package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.Gstin;

public interface GstinRepository extends JpaRepository<Gstin, Long> {

}
