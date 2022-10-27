package com.aminosoft.simplestockmanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "jmStoreStock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreStock implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -819052150177017524L;

	@EmbeddedId
	private StoreStockId storeStockId;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "productId")
	private Product products;
	
	@ManyToOne
	@MapsId("storeId")
	@JoinColumn(name = "storeId")
	private Store stores;

	@Column
	private double stock;
	
	
	

	public StoreStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreStock(Product products, Store stores, double stock) {
		super();
		this.storeStockId=new StoreStockId(stores.getId(),products.getId() );
		this.products = products;
		this.stores = stores;
		this.stock = stock;
	}

	public StoreStockId getStoreStockId() {
		return storeStockId;
	}

	public void setStoreStockId(StoreStockId storeStockId) {
		this.storeStockId = storeStockId;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Store getStores() {
		return stores;
	}

	public void setStores(Store stores) {
		this.stores = stores;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
	
	
	
}


//https://stackoverflow.com/questions/23837561/jpa-2-0-many-to-many-with-extra-column

//https://huongdanjava.com/many-many-relationship-extra-columns-jpa.html