package com.aminosoft.simplestockmanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreStockId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4645020541526096950L;

	@Column(name = "storeId")
	private int storeId;
	
	@Column(name = "productId")
	private int productId;

	public StoreStockId(Integer storeId, Integer productId) {
		super();
		this.storeId = storeId;
		this.productId = productId;
	}

	public StoreStockId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
