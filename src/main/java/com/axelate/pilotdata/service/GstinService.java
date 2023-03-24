package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.Gstin;
import com.axelate.pilotdata.repository.GstinRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class GstinService {
	
	private final GstinRepository repository;
	
	   public List<Gstin> findAll() {
	        return repository.findAll();
	    }
	    public Gstin save(Gstin gstin) {
	        return repository.save(gstin);
	    }
	    
	    public void deleteById(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public Gstin findGstinById(Long id) {
	        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
	               
	    }
		public Gstin updateGstin(Long id, Gstin gstin) {
			return repository.save(gstin);			
		}
}
