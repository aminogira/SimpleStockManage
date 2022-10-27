package com.aminosoft.simplestockmanage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aminosoft.simplestockmanage.model.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Query("select c from m_category c where c.name ilike ?1 ")
	Optional<Category> findByName(String name);
	
}
