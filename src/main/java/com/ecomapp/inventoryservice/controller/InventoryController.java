package com.ecomapp.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapp.inventoryservice.dto.ReserveInventoryReqDto;
import com.ecomapp.inventoryservice.dto.ReserveInventoryResDto;
import com.ecomapp.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/reserve")
	public ResponseEntity<ReserveInventoryResDto> reserveInventory(@RequestBody ReserveInventoryReqDto requestDto) {
		ReserveInventoryResDto reserveInventoryResDto = inventoryService.reserveInventory(requestDto);
		return new ResponseEntity<>(reserveInventoryResDto, HttpStatus.OK);
	}
}
