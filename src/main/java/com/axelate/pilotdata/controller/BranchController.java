package com.axelate.pilotdata.controller;

import static com.axelate.pilotdata.controller.BranchController.BRANCH_BASE_URL;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axelate.pilotdata.model.Branch;
import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.service.BranchService;
import com.axelate.pilotdata.service.CompanyAddressService;
import com.axelate.pilotdata.service.GstinService;
import com.axelate.pilotdata.service.TaxService;
import com.axelate.pilotdata.service.TransactionNumberSeriesService;
import com.axelate.pilotdata.service.WarehouseService;
import com.fasterxml.jackson.core.sym.Name;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(BRANCH_BASE_URL)
@Validated
@AllArgsConstructor
public class BranchController {
	
	public static final String BRANCH_BASE_URL = "/branch";
	public static final String BRANCH_BY_ID_URL = "/branch/{id}";

	private final BranchService service;
	private final CompanyAddressService companyAddressService;
	private final GstinService gstinService;
	private final TransactionNumberSeriesService numberSeriesService;
	private final WarehouseService warehouseService;

	@Operation(summary = "Get  list of branches", description = "Get list of branches")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Branch> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a branch by Id", description = "Get a branch by Id")
	@GetMapping(value =BRANCH_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Branch findById(@PathVariable Long id) {
		return service.findBranchById(id);
	}
	
	@Operation(summary = "save a branch", description = "Save branch")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Branch saveBranch(@RequestBody Branch branch) {
		return service.save(branch);
	}
	
	@Operation(summary = "delete a branch", description = "Delete a branch")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBranch(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a branch", description = "update a branch")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Branch updateBranch(@PathVariable Long id, @RequestBody Branch branchDetails) {
		Branch branch = service.findBranchById(id);
		branch.toBuilder().
		name(branchDetails.getName())
		.address(companyAddressService.findCompanyAddressById(branchDetails.getAddress().getAddressId()))
		.primaryContact(branchDetails.getPrimaryContact())
		.gstin(gstinService.findGstinById(branchDetails.getGstin().getGstin_id()))
		.transactionNumberSeries(numberSeriesService.findTransactionNumberSeriesById(branchDetails.getTransactionNumberSeries().getSeries_id()))
		.defaultTransactionNumberSeries(numberSeriesService.findTransactionNumberSeriesById(branchDetails.getDefaultTransactionNumberSeries().getSeries_id()))
		.warehouse(warehouseService.findWarehouseById(branchDetails.getWarehouse().getWarehouseId()))
		.build();		
		 return service.updateBranch(id, branch);
	}

}
