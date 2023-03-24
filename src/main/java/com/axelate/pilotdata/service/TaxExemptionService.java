package com.axelate.pilotdata.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.TaxExemptions;
import com.axelate.pilotdata.repository.TaxExemptionRepository;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class TaxExemptionService {
	
	
	private final TaxExemptionRepository repository;
	
    public List<TaxExemptions> findAll() {
        return repository.findAll();
    }
    public TaxExemptions save(TaxExemptions taxExemptions) {
        return repository.save(taxExemptions);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public TaxExemptions findTaxExemptionById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
               
    }
	public TaxExemptions updateTaxExemption(Long id, TaxExemptions TaxExemptions) {
		return repository.save(TaxExemptions);
		
	}


}
