package com.ecomapp.inventoryservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveInventoryReqDto {
	private List<LineItemRequestDto> lineItems;
}
