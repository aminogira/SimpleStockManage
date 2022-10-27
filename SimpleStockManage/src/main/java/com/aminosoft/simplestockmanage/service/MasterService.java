package com.aminosoft.simplestockmanage.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aminosoft.simplestockmanage.model.Category;
import com.aminosoft.simplestockmanage.model.Product;
import com.aminosoft.simplestockmanage.model.Store;
import com.aminosoft.simplestockmanage.repo.CategoryRepo;
import com.aminosoft.simplestockmanage.repo.ProductRepo;
import com.aminosoft.simplestockmanage.repo.StoreRepo;

@Service
public class MasterService {

	private final CategoryRepo repoCategory;
	private final ProductRepo repoProduct;
	private final StoreRepo repoStore;

	@Autowired
	public MasterService(CategoryRepo cr, ProductRepo pr, StoreRepo sr) {
		repoCategory = cr;
		repoProduct = pr;
		repoStore = sr;
	}

	public List<Product> getProduct() {
		return repoProduct.findAll();
	}
	public List<Category> getCategories(){
		return repoCategory.findAll();
	}
	public List<Store> getStores(){
		return repoStore.findAll();
	}

	public void addNewProduct(Product product) {
		Optional<Product> proByName = repoProduct.findByName(product.getName());
		if (proByName.isPresent()) {
			throw new IllegalStateException("Product Already Added");
		}
		repoProduct.save(product);
	}
	
	public void addNewCategory(Category cat) {
		Optional<Category> catByName = repoCategory.findByName(cat.getName());
		if(catByName.isPresent()) {
			throw new IllegalStateException("Category Already Added");
		}
		repoCategory.save(cat);
	}
	
	public void addNewStore(Store store) {
		Optional<Store> storeByName = repoStore.findByName(store.getName());
		if(storeByName.isPresent()) {
			throw new IllegalStateException("Store already added");
		}
		repoStore.save(store);
	}
	

	public void deleteProduct(int id) {
		boolean exist = repoProduct.existsById(id);
		if (!exist) {
			throw new IllegalStateException("product " + id + " not exists");
		} else {
			repoProduct.deleteById(id);
		}
	}
	
	public void deleteCategory(int id) {
		boolean exist=repoCategory.existsById(id);
		if(!exist) {
			throw new IllegalStateException("category "+ id + " not exists");
		}else {
			repoCategory.deleteById(id);
		}
	}
	
	public void deleteStore(int id) {
		boolean exist=repoStore.existsById(id);
		if(!exist) {
			throw new IllegalStateException("Store " + id + " not found");
		}else {
			repoStore.deleteById(id);
		}
	}
	
	
	@Transactional
	public void updateProduct(int productId, String name, String description, double price) {
		Product pdInDB = repoProduct.findById(productId)
				.orElseThrow( () -> new IllegalStateException("Product not found " + productId ) );
		if(name != null && name.length() >0 && !Objects.equals(pdInDB.getName(), name)) {
			Optional<Product> productOptional=repoProduct.findByName(name);
			if(productOptional.isPresent()) {
				throw new  IllegalStateException("Product is exist");
			}
			pdInDB.setName(name);
		}
		if(description !=null && description.length()>0 && !Objects.equals(pdInDB.getDescription(), description)) {
			pdInDB.setDescription(description);
		}
		pdInDB.setPrice(price);
	}
	
	@Transactional
	public void updateCategory(int catId,String name,String description) {
		Category catInDb = repoCategory.findById(catId)
				.orElseThrow(() -> new IllegalStateException("Category Not found " + catId) );
		if(name != null && name.length()>0 && !Objects.equals(name, catInDb.getName())) {
			Optional<Category> catOptional = repoCategory.findByName(name);
			if(catOptional.isPresent()) {
				throw new IllegalStateException("Category is exist");
			}
			catInDb.setName(name);
		}
		if(description != null && description.length()>0  && !Objects.equals(description, catInDb.getDescription())){
			catInDb.setDescription(description);
		}
	}
	
	@Transactional
	public void updateStore(int id, String name) {
		Store storeInDb = repoStore.findById(id)
				.orElseThrow(() -> new IllegalStateException("Store not found " + id) );
		if(name != null && name.length()>0 && !Objects.equals(name, storeInDb.getName())){
			Optional<Store> storeOptional = repoStore.findByName(name);
			if(storeOptional.isPresent()) {
				throw new IllegalStateException("the name you enterd already exist");
			}
			storeInDb.setName(name);
		}	
	}
	

}
