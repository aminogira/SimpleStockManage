package com.aminosoft.simplestockmanage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.aminosoft.simplestockmanage.model.Store;

public interface StoreRepo extends JpaRepository<Store, Integer> {

	@Query("select s from m_Store s where s.name ilike ?1 ")
	Optional<Store> findByName(String name);
}
