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
@Table(name = "Tax")
public class Tax implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tax_id")
	private Long taxId;

	@Column(name = "tax_name")
	private String taxName;

	@Column(name = "tax_percentage")
	private double taxPercentage;

	@Column(name = "tax_type")
	private String taxType;

	@Column(name = "tax_specific_type")
	private String taxSpecificType;

//	@Column(name = "update_recurring_invoice")
//	private boolean updateRecurringInvoice;
//
//	@Column(name = "update_recurring_expense")
//	private boolean updateRecurringExpense;
//
//	@Column(name = "update_draft_invoice")
//	private boolean updateDraftInvoice;
//
//	@Column(name = "update_recurring_bills")
//	private boolean updateRecurringBills;
//
//	@Column(name = "update_draft_so")
//	private boolean updateDraftSo;
//
//	@Column(name = "update_subscription")
//	private boolean updateSubscription;
//
//	@Column(name = "update_project")
//	private boolean updateProject;

	@Column(name = "is_editable")
	private boolean isEditable;


}


