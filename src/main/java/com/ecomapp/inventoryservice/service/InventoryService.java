package com.ecomapp.inventoryservice.service;

import com.ecomapp.inventoryservice.dto.ReserveInventoryReqDto;
import com.ecomapp.inventoryservice.dto.ReserveInventoryResDto;

public interface InventoryService {

	public ReserveInventoryResDto reserveInventory(ReserveInventoryReqDto requestDto);

}
