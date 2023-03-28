package com.axelate.pilotdata.controller;

import static com.axelate.pilotdata.controller.TaxController.TAX_BASE_URL;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.model.Tax.TaxBuilder;
import com.axelate.pilotdata.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(TAX_BASE_URL)
@Validated
@AllArgsConstructor
public class TaxController {
	public static final String TAX_BASE_URL = "/tax";
	public static final String TAX_BY_ID_URL = "/{id}";

	private final TaxService service;

	@Operation(summary = "Get  list of taxes", description = "Get list of taxes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tax> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a tax by Id", description = "Get a tax by Id")
	@GetMapping(value =TAX_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tax findById(@PathVariable Long id) {
		return service.findTaxById(id);
	}
	
	@Operation(summary = "save a tax", description = "Save t ax")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public Tax saveTax(@RequestBody Tax tax) {
		return service.save(tax);
	}
	
	@Operation(summary = "delete a tax", description = "Delete a tax")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void  deleteTax(@RequestParam Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a tax", description = "update a tax")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Tax updateTax(@RequestParam Long id, @RequestBody Tax taxDetails) {
		 Tax tax = service.findTaxById(id);
		 Tax taxBulider= Tax.builder().
				taxId(id).
				taxName(taxDetails.getTaxName())
				.taxPercentage(taxDetails.getTaxPercentage())
				.taxSpecificType(tax.getTaxSpecificType())
				.taxType(tax.toString())				
				.build();		
		 return service.updateTax(id, taxBulider);
	}
	

}
