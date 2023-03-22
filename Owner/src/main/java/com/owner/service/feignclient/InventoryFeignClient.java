package com.owner.service.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.owner.service.exception.InventoryNotFoundException;
import com.owner.service.model.Inventory;


@FeignClient(name="inventoryservice" , url="http://localhost:8083/inventory")
public interface InventoryFeignClient {
	        @GetMapping("/all")
            public ResponseEntity<List<Inventory>> showAllInventory(@RequestHeader("Authorization") String token);
     
            @GetMapping("/{id}")
            public ResponseEntity<Inventory> showById(@PathVariable("id")int id,@RequestHeader("Authorization") String token)throws InventoryNotFoundException;


			@PostMapping("/add")
			public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token) throws InventoryNotFoundException;

			@PutMapping("/update")
			public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token) throws InventoryNotFoundException;
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException;
			
		}



