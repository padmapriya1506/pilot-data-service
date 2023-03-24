package com.axelate.pilotdata.controller;

import static com.axelate.pilotdata.controller.GstinController.GSTIN_BASE_URL;

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

import com.axelate.pilotdata.model.Gstin;
import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.service.GstinService;
import com.axelate.pilotdata.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(GSTIN_BASE_URL)
@Validated
@AllArgsConstructor
public class GstinController {
	public static final String GSTIN_BASE_URL = "/gstin";
	public static final String GSTIN_BY_ID_URL = "/gstin/{id}";

	private final GstinService service;

	@Operation(summary = "Get  list of gstins", description = "Get list of gstins")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Gstin> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a gstin by Id", description = "Get a gstin by Id")
	@GetMapping(value =GSTIN_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Gstin findById(@PathVariable Long id) {
		return service.findGstinById(id);
	}
	
	@Operation(summary = "save a gstin", description = "Save gstin")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Gstin saveGstin(@RequestBody Gstin gstin) {
		return service.save(gstin);
	}
	
	@Operation(summary = "delete a gstin", description = "Delete a gstin")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteGstin(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a gstin", description = "update a gstin")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Gstin updateGstin(@PathVariable Long id, @RequestBody Gstin gstinDetails) {
		 Gstin gstin = service.findGstinById(id);
		 gstin.toBuilder()
		 .gstinNumber(gstinDetails.getGstinNumber())
		 .businessLegalName(gstinDetails.getBusinessLegalName())
		 .businessTradeName(gstin.getBusinessTradeName())
		 .registerdOn(gstinDetails.getRegisterdOn())
		 .reverseCharge(gstinDetails.getReverseCharge())
		 .importOrExport(gstin.getImportOrExport())
		 .digitalServices(gstinDetails.getDigitalServices())						
		 .build();		
		 return service.updateGstin(id, gstin);
	}
	

}
