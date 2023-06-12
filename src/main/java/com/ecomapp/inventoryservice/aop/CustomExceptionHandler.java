package com.ecomapp.inventoryservice.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecomapp.inventoryservice.dto.ReserveInventoryResDto;
import com.ecomapp.inventoryservice.exception.InventoryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InventoryException.class)
	public ResponseEntity<ReserveInventoryResDto> handleInventoryExceptions(InventoryException ex) {
		ReserveInventoryResDto inventoryResDto = getResponseDto(ex);
		return new ResponseEntity<ReserveInventoryResDto>(inventoryResDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ReserveInventoryResDto> handleExceptions(Exception ex) {
		ReserveInventoryResDto inventoryResDto = getResponseDto(ex);
		return new ResponseEntity<ReserveInventoryResDto>(inventoryResDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ReserveInventoryResDto getResponseDto(Exception ex) {
		log.error("Exception {}", ex);
		return ReserveInventoryResDto.builder()
				.message(ex.getMessage())
				.isReserved(false)
				.build();
	}
}
