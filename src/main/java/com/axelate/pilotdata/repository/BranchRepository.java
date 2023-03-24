package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
