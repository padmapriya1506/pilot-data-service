package com.axelate.pilotdata.controller;

import static com.axelate.pilotdata.controller.CompanyAddressController.COMPANY_ADDRESS_BASE_URL;

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

import com.axelate.pilotdata.model.CompanyAddress;
import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.service.CompanyAddressService;
import com.axelate.pilotdata.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(COMPANY_ADDRESS_BASE_URL)
@Validated
@AllArgsConstructor
public class CompanyAddressController {
	
	public static final String COMPANY_ADDRESS_BASE_URL = "/companyAddress";
	public static final String COMPANY_ADDRESS_BY_ID_URL = "/company/{id}";

	private final CompanyAddressService service;

	@Operation(summary = "Get  list of company addresses", description = "Get list of company addresses")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyAddress> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a company address by Id", description = "Get a company address by Id")
	@GetMapping(value =COMPANY_ADDRESS_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyAddress findById(@PathVariable Long id) {
		return service.findCompanyAddressById(id);
	}
	
	@Operation(summary = "save a company address", description = "Save company address")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyAddress saveCompanyAddress(@RequestBody CompanyAddress companyAddress) {
		return service.save(companyAddress);
	}
	
	@Operation(summary = "delete a company address", description = "Delete a company address")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCompanyAdddress(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a company address", description = "update a company address")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyAddress updateCompanyAddress(@PathVariable Long id, @RequestBody CompanyAddress companyAddressDetails) {
		 CompanyAddress companyAddress = service.findCompanyAddressById(id);
		 companyAddress.toBuilder()
		 .street1(companyAddressDetails.getStreet1())
		 .street2(companyAddressDetails.getStreet2())
		 .city(companyAddressDetails.getCity())
		 .stateId(companyAddressDetails.getStateId())
		 .state(companyAddressDetails.getState())
		 .zipcode(companyAddressDetails.getZipcode())
		 .phone(companyAddressDetails.getPhone())
		 .fax(companyAddressDetails.getFax())
		 .website(companyAddressDetails.getWebsite())
		 .build();		
		 return service.updateCompanyAddress(id, companyAddress);
	}

}
