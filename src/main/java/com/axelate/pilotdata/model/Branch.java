package com.axelate.pilotdata.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "branch")
public class Branch implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_id")
	private Long branch_id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private CompanyAddress address;
	
	@Column(name = "primary_contact")
	private String primaryContact;
	
	@OneToOne
	@JoinColumn(name = "gstin_id")
	private Gstin gstin;
	
	@OneToOne
	@JoinColumn(name = "transaction_number_series_id")
	private  TransactionNumberSeries transactionNumberSeries;
	
	@OneToMany
	@JoinColumn(name = "default_transaction_number_series_id")
	private  TransactionNumberSeries defaultTransactionNumberSeries;
	
	@OneToMany
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	

}
