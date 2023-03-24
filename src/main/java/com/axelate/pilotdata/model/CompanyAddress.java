package com.axelate.pilotdata.model;

import java.io.Serializable;

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
@Table(name = "company_address")
public class CompanyAddress implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	
	private String street1;
	private String street2;
	private String city;
	
	@Column(name = "state_id")
	private String stateId;
	
	private String state;
	
	private String zipcode;
	
	private String phone;
	
	private String fax;
	
	private String website;
	
	
	
}
