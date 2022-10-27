package com.aminosoft.simplestockmanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mStore")
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4437838030243183142L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "jmProductStore",joinColumns = @JoinColumn(name="stoId"), inverseJoinColumns = @JoinColumn(name="proId"))
//	private List<Product> products;

	@OneToMany(mappedBy = "stores" ,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StoreStock> products=new ArrayList<>(); 
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<StoreStock> getProducts() {
		return products;
	}


	public void setProducts(List<StoreStock> products) {
		this.products = products;
	}



	
	
	
}
