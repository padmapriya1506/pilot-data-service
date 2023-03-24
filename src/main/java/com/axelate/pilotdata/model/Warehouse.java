package com.axelate.pilotdata.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "warehouse_id")
	private Long warehouseId;
	
	@OneToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	private String name;
	
	private String attention;
	
	private String street1;
	
	private String street2;
	
	private String city;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "country_desc")
	private String countryDesc;
	
	private String state;
	
	private String Zipcode;
	
	private String phone;
	
	@Email
	private String email;
	
	
	
	
	
}
