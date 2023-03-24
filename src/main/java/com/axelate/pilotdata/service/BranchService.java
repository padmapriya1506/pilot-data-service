package com.axelate.pilotdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.pilotdata.exception.NotFoundException;
import com.axelate.pilotdata.model.Branch;
import com.axelate.pilotdata.repository.BranchRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class BranchService {
	
	private final BranchRepository repository;
	
	   public List<Branch> findAll() {
	        return repository.findAll();
	    }
	    public Branch save(Branch branch) {
	        return repository.save(branch);
	    }
	    
	    public void deleteById(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public Branch findBranchById(Long id) {
	        return repository.findById(id).orElseThrow(() -> new NotFoundException("No tax found with id: " + id));
	               
	    }
		public Branch updateBranch(Long id, Branch branch) {
			return repository.save(branch);			
		}

}
