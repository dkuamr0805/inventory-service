package com.ecomapp.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapp.inventoryservice.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

	public InventoryEntity getByProductCode(String productCode);
}
