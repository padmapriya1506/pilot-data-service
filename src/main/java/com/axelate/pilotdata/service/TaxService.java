package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.repository.TaxRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class TaxService {
	
	private final TaxRepository repository;
	
    public List<Tax> findAll() {
        return repository.findAll();
    }
    public Tax save(Tax tax) {
        return repository.save(tax);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Tax findTaxById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
               
    }
	public Tax updateTax(Long id, Tax tax) {
		return repository.save(tax);
		
	}


}
