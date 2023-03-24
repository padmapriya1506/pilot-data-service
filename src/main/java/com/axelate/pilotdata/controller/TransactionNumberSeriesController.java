package com.axelate.pilotdata.controller;

import static com.axelate.pilotdata.controller.TransactionNumberSeriesController.TXN_NUMBER_SERIES_BASE_URL;

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

import com.axelate.pilotdata.model.Tax;
import com.axelate.pilotdata.model.TransactionNumberSeries;
import com.axelate.pilotdata.service.BranchService;
import com.axelate.pilotdata.service.TaxService;
import com.axelate.pilotdata.service.TransactionNumberSeriesService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(TXN_NUMBER_SERIES_BASE_URL)
@Validated
@AllArgsConstructor
public class TransactionNumberSeriesController {
	
	public static final String TXN_NUMBER_SERIES_BASE_URL = "/numseries";
	public static final String TXN_NUMBER_SERIES_BY_ID_URL = "/numseries/{id}";

	private final TransactionNumberSeriesService service;
	private final BranchService branchService;

	@Operation(summary = "Get  list of transaction number series", description = "Get list of transaction number series")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionNumberSeries> findAll() {
		return service.findAll();
	}
	

	@Operation(summary = "Get a transaction number series by Id", description = "Get a transaction number series by Id")
	@GetMapping(value =TXN_NUMBER_SERIES_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public TransactionNumberSeries findById(@PathVariable Long id) {
		return service.findTransactionNumberSeriesById(id);
	}
	
	@Operation(summary = "save a transaction number series", description = "Save transaction number series")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public TransactionNumberSeries saveTransactionNumberSeries(@RequestBody TransactionNumberSeries transactionNumberSeries) {
		return service.save(transactionNumberSeries);
	}
	
	@Operation(summary = "delete a transaction number series", description = "Delete a transaction number series")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTransactionNumberSeries(@PathVariable Long id) {
		 service.deleteById(id);
	}
	
	@Operation(summary = "update a transaction number series", description = "update a transaction number series")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public TransactionNumberSeries updateTransactionNumberSeries(@PathVariable Long id, @RequestBody TransactionNumberSeries txnNumSeriesDetails) {
		TransactionNumberSeries transactionNumberSeries = service.findTransactionNumberSeriesById(id);
		transactionNumberSeries.toBuilder()
		.branch(branchService.findBranchById(txnNumSeriesDetails.getBranch().getBranch_id()))
		.name(txnNumSeriesDetails.getName())
		.type(txnNumSeriesDetails.getType())
		.prefix(txnNumSeriesDetails.getPrefix())
		.suffix(txnNumSeriesDetails.getSuffix())								
		.build();		
		 return service.updateTransactionNumberSeries(id, txnNumSeriesDetails);
	}
	

}
