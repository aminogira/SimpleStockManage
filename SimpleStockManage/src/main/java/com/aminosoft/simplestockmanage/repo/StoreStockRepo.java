package com.aminosoft.simplestockmanage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aminosoft.simplestockmanage.model.StoreStock;
import com.aminosoft.simplestockmanage.model.StoreStockId;

public interface StoreStockRepo extends JpaRepository<StoreStock, StoreStockId> {

}
