package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.Warehouse;
import com.axelate.pilotdata.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class WarehouseService {

	private final WarehouseRepository repository;
	
    public List<Warehouse> findAll() {
        return repository.findAll();
    }
    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Warehouse findWarehouseById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
               
    }
	public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
		return repository.save(warehouse);
		
	}
}
