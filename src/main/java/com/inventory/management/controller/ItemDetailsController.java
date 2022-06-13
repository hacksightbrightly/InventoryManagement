package com.inventory.management.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.entities.ItemDetails;
import com.inventory.management.services.ItemDetailsServices;
import com.inventory.management.services.ItemDetailsServicesInterface;

@RestController
public class ItemDetailsController
{

	@Autowired
	private ItemDetailsServicesInterface itdServices;

	@GetMapping("/itemDetails")
	public ResponseEntity<List<ItemDetails>> handler1() {
		List<ItemDetails> itdList = this.itdServices.getAllItemDetails();

		if (itdList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(itdList));
	}

	@GetMapping("/itemDetails/{id}")
	public ResponseEntity<ItemDetails> handler2(@PathVariable("id") int id) {
		ItemDetails itd = this.itdServices.getItemDetailsById(id);

		if (itd == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(itd));
	}

	@PostMapping("/itemDetails")
	public ResponseEntity<ItemDetails> handler3(@RequestBody ItemDetails itd) {
		try {
			this.itdServices.addItemDetails(itd);
			return ResponseEntity.status(HttpStatus.CREATED).body(itd);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/itemDetails/{id}")
	public ResponseEntity<Void> handler4(@PathVariable("id") int id) {
		try {
			this.itdServices.deleteItemDetails(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/itemDetails/{id}")
	public ResponseEntity<ItemDetails> handler5(@RequestBody ItemDetails itd, @PathVariable("id") int id) {
		try {
			this.itdServices.updateItemDetails(itd, id);
			return ResponseEntity.of(Optional.of(itd));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
