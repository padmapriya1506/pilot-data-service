package com.axelate.pilotdata.controller;


import static com.axelate.pilotdata.controller.WarehouseController.WAREHOUSE_BASE_URL;

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
import com.axelate.pilotdata.model.Warehouse;
import com.axelate.pilotdata.service.BranchService;
import com.axelate.pilotdata.service.TaxExemptionService;
import com.axelate.pilotdata.service.WarehouseService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(WAREHOUSE_BASE_URL)
@Validated
@AllArgsConstructor
public class WarehouseController {
	
	public static final String WAREHOUSE_BASE_URL = "/warehouse";
	public static final String WAREHOUSE_BY_ID_URL = "/warehouse/{id}";

	private final WarehouseService service;
	private final BranchService branchService;

	@Operation(summary = "Get  list of tax warehouses", description = "Get list of warehouses")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Warehouse> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a warehoue by Id", description = "Get a warehoue by Id")
	@GetMapping(value =WAREHOUSE_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Warehouse findById(@PathVariable Long id) {
		return service.findWarehouseById(id);
	}
	
	@Operation(summary = "save a warehoue", description = "Save a warehoue")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Warehouse saveWarehouse(@RequestBody Warehouse warehouse) {
		return service.save(warehouse);
	}
	
	@Operation(summary = "delete a warehouse", description = "Delete a warehouse")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteWarehouse(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a tax", description = "update a tax")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Warehouse updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
		Warehouse warehouse = service.findWarehouseById(id);
		warehouse.toBuilder().
		branch(branchService.findBranchById(warehouse.getBranch().getBranch_id()))
		.name(warehouseDetails.getName())
		.attention(warehouseDetails.getAttention())
		.street1(warehouseDetails.getStreet1())
		.street2(warehouseDetails.getStreet2())
		.city(warehouseDetails.getCity())
		.countryCode(warehouseDetails.getCountryCode())
		.countryDesc(warehouseDetails.getCountryDesc())
		.state(warehouseDetails.getState())
		.Zipcode(warehouseDetails.getZipcode())
		.email(warehouseDetails.getEmail())										
	     .build();		
		 return service.updateWarehouse(id, warehouse);
	}

}
