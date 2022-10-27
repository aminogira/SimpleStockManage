package com.aminosoft.simplestockmanage;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aminosoft.simplestockmanage.model.Category;
import com.aminosoft.simplestockmanage.model.Product;
import com.aminosoft.simplestockmanage.model.Store;
import com.aminosoft.simplestockmanage.model.StoreStock;
import com.aminosoft.simplestockmanage.repo.CategoryRepo;
import com.aminosoft.simplestockmanage.repo.ProductRepo;
import com.aminosoft.simplestockmanage.repo.StoreRepo;
import com.aminosoft.simplestockmanage.repo.StoreStockRepo;

@SpringBootApplication
public class SimpleStockManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleStockManageApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner mappingDemo(CategoryRepo repoCat, ProductRepo repoProduct, StoreRepo repoStore,StoreStockRepo repoStoreStock) {
		return ar -> {
			
			
			
			Category c1=new Category();
			c1.setName("food");
			c1.setDescription("food category");
			//repoCat.save(c1);
			Category c2=new Category();
			c2.setName("fruit");
			c2.setDescription("sub food");
			//repoCat.save(c2);
			Category c3=new Category();
			c3.setName("Vegitable");
			c3.setDescription("sub food");
			//repoCat.save(c3);
			Category c4=new Category();
			c4.setName("Bekary");
			c4.setDescription("sub food");
			//repoCat.save(c4);
			repoCat.saveAll(Arrays.asList(c1,c2,c3,c4));

			Store s0=new Store();
			s0.setName("MainStore");
			Store s1=new Store();
			s1.setName("BackStock");
			repoStore.saveAll(Arrays.asList(s0,s1));
			
			Product p0=new Product();
			p0.setName("Cake");
			p0.setDescription("Bekari Cake");
			p0.setPrice(300);
			Product p2=new Product();
			p2.setName("Pumpkin");
			p2.setDescription("Vegitable");
			p2.setPrice(250);
			Product p3=new Product();
			p3.setName("Apple");
			p3.setDescription("Fruit");
			p3.setPrice(25);
			repoProduct.saveAll(Arrays.asList(p0,p2,p3));
			

			
			c1.getProducts().addAll(Arrays.asList(p0));
			c1.getProducts().addAll(Arrays.asList(p2));
			c1.getProducts().addAll(Arrays.asList(p3));
			
			c4.getProducts().addAll(Arrays.asList(p0));
			c3.getProducts().addAll(Arrays.asList(p2));
			c2.getProducts().addAll(Arrays.asList(p3));
			repoCat.saveAll(Arrays.asList(c1,c2,c3,c4));
			
			
			StoreStock ss1=new StoreStock(p3, s1, 10);
			StoreStock ss2=new StoreStock(p3, s0, 100);
			repoStoreStock.saveAll(Arrays.asList(ss1,ss2));
			
			
			
			

			
		};
	}

}
