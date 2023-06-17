package com.supermarket.demo.Super.Market.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Supplier {
	
	@Id
	@Column(name="supplier_id")
	private Long supplierId;
	@Column(name="supplier_name")
	private String supplierName;
	@Column(name="supplier_email")
	private String supplierEmail;
	@Column(name="supplier_contact")
	private String supplierContact;
	
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Supplier(Long supplierId, String supplierName, String supplierEmail, String supplierContact) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.supplierContact = supplierContact;
	}


	public Long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getSupplierEmail() {
		return supplierEmail;
	}


	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}


	public String getSupplierContact() {
		return supplierContact;
	}


	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}


	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierEmail="
				+ supplierEmail + ", supplierContact=" + supplierContact + "]";
	}
	
	
	
	
	
	
}