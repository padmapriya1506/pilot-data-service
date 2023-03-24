package com.axelate.pilotdata.controller;


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

import com.axelate.pilotdata.model.TaxExemptions;
import com.axelate.pilotdata.service.TaxExemptionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static com.axelate.pilotdata.controller.TaxExemptionController.TAX_EXEMPTION_BASE_URL;

@Slf4j
@RestController
@RequestMapping(TAX_EXEMPTION_BASE_URL)
@Validated
@AllArgsConstructor
public class TaxExemptionController {

	public static final String TAX_EXEMPTION_BASE_URL = "/exemption";
	public static final String TAX_EXEMPTION_BY_ID_URL = "/exemption/{id}";

	private final TaxExemptionService service;

	@Operation(summary = "Get  list of tax exemptions", description = "Get list of tax exemptions")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaxExemptions> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a tax exemption by Id", description = "Get a tax exemption by Id")
	@GetMapping(value =TAX_EXEMPTION_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public TaxExemptions findById(@PathVariable Long id) {
		return service.findTaxExemptionById(id);
	}
	
	@Operation(summary = "save a tax exemption", description = "Save a tax exemption")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public TaxExemptions saveTax(@RequestBody TaxExemptions taxExemptions) {
		return service.save(taxExemptions);
	}
	
	@Operation(summary = "delete a tax exemption", description = "Delete a tax exemption")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTaxExemptions(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a tax", description = "update a tax")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public TaxExemptions updateTaxExemption(@PathVariable Long id, @RequestBody TaxExemptions taxExemptionDetails) {
		TaxExemptions taxExemption = service.findTaxExemptionById(id);
		taxExemption.toBuilder().
				reason(taxExemptionDetails. getReason())
				.associatedWith(taxExemptionDetails.getAssociatedWith())
				.description(taxExemptionDetails.getDescription())							
				.build();		
		 return service.updateTaxExemption(id, taxExemption);
	}

}
