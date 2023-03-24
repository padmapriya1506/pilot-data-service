package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.TransactionNumberSeries;
import com.axelate.pilotdata.model.Warehouse;
import com.axelate.pilotdata.repository.TransactionNumberSeriesRepository;
import com.axelate.pilotdata.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class TransactionNumberSeriesService {
	
	private final TransactionNumberSeriesRepository repository;
	
    public List<TransactionNumberSeries> findAll() {
        return repository.findAll();
    }
    public TransactionNumberSeries save(TransactionNumberSeries transactionNumberSeries) {
        return repository.save(transactionNumberSeries);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public TransactionNumberSeries findTransactionNumberSeriesById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
               
    }
	public TransactionNumberSeries updateTransactionNumberSeries(Long id, TransactionNumberSeries transactionNumberSeries) {
		return repository.save(transactionNumberSeries);
		
	}
}


