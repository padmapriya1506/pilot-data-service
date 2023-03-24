package com.axelate.pilotdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axelate.pilotdata.model.TransactionNumberSeries;

public interface TransactionNumberSeriesRepository  extends JpaRepository<TransactionNumberSeries, Long> {

}
