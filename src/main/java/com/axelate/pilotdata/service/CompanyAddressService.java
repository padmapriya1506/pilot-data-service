package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.CompanyAddress;
import com.axelate.pilotdata.repository.CompanyAddressRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CompanyAddressService {
	
	private final CompanyAddressRepository repository;
	
	   public List<CompanyAddress> findAll() {
	        return repository.findAll();
	    }
	    public CompanyAddress save(CompanyAddress companyAddress) {
	        return repository.save(companyAddress);
	    }
	    
	    public void deleteById(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public CompanyAddress findCompanyAddressById(Long id) {
	        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
	               
	    }
		public CompanyAddress updateCompanyAddress(Long id, CompanyAddress companyAddress) {
			return repository.save(companyAddress);			
		}

}
