package com.ecomapp.inventoryservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapp.inventoryservice.dto.LineItemRequestDto;
import com.ecomapp.inventoryservice.dto.ReserveInventoryReqDto;
import com.ecomapp.inventoryservice.dto.ReserveInventoryResDto;
import com.ecomapp.inventoryservice.entity.InventoryEntity;
import com.ecomapp.inventoryservice.exception.InventoryException;
import com.ecomapp.inventoryservice.repository.InventoryRepository;
import com.ecomapp.inventoryservice.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public ReserveInventoryResDto reserveInventory(ReserveInventoryReqDto requestDto) {
		
		for (LineItemRequestDto lineItem : requestDto.getLineItems()) {
			InventoryEntity inventoryEntity = inventoryRepository.getByProductCode(lineItem.getProductCode());
			
			if (inventoryEntity == null) {
				throw new InventoryException("Inventory not available");
			} else if (inventoryEntity.getAvailableQuantity() < lineItem.getQuantity()) {
				throw new InventoryException("Insufficient inventory");
			}
			
			inventoryEntity.setAvailableQuantity(inventoryEntity.getAvailableQuantity() - lineItem.getQuantity());
			inventoryRepository.save(inventoryEntity);
		}
		
		return ReserveInventoryResDto.builder()
				.message("Inventory reserved successfully")
				.isReserved(true)
				.build();
	}

}
