package com.project.application.model;

import java.lang.reflect.Array;
import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class ShoppingCart {
	
	private Array items;
	
	private BigDecimal amount;

	public Array getItems() {
		return items;
	}

	public void setItems(Array items) {
		this.items = items;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
