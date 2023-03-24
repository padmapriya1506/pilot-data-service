package com.axelate.pilotdata.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "gstin")
public class Gstin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gstin_id")
	private Long gstin_id;
	
	@Column(name = "gstin_number")
	private String gstinNumber;
	
	@Column(name = "business_legal_name")
	private String businessLegalName;
	
	@Column(name = "business_trade_name")
	private String businessTradeName;
	
	@Column(name = "registered_on")
	private Date registerdOn;
	
	@Column(name = "reverse_charge")
	private String reverseCharge;
	
	@Column(name = "import_or_export")
	private String importOrExport;
	
	@Column(name = "digital_services")
	private String digitalServices;
}
