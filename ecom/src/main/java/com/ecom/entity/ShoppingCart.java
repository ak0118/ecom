package com.ecom.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.ecom.beans.AbstractEntity;
import com.ecom.beans.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shopping_cart")
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCart extends AbstractEntity<Long> implements Serializable{

	@Column(name = "name")
	private String name = "";
	
	@Column(name = "cart_id")
	private String cartId = "";
	
	@Column(name = "item")
	private String item = "";
	
	@Column(name = "ph_no")
	private String phNo = "";
	
	@Column(name = "otp")
	private String otp = "";
	
	@Column(name = "is_validated", columnDefinition="boolean default false")
	private Boolean isValidated;
	
	@PrePersist
	public void defaultIsValidated() {
		if (isValidated == null) {
			isValidated = false;
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartid) {
		this.cartId = cartId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public Boolean isValidated() {
		return isValidated;
	}
	public void setValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}
	
}
