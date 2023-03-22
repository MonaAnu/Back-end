package com.manager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.manager.exception.InventoryNotFoundException;
import com.manager.feignclient.InventoryFeignClient;
import com.manager.model.Inventory;


@RestController
@RequestMapping("/manager")
public class InventoryManagerController {
	@Autowired
	private InventoryFeignClient inventoryClient;
	
	
	@GetMapping("/all")
    public ResponseEntity<List<Inventory>> showAllInventory(@RequestHeader("Authorization") String token){
		
		
             return inventoryClient.showAllInventory(token);
            }
           
	@GetMapping("/inv/{id}")
    public ResponseEntity<Inventory> showById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException {
	
            return inventoryClient.showById(id, token);
            }
            
	
	@PostMapping("/addInventory")
	public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token) throws InventoryNotFoundException {

		return inventoryClient.addInventoryDetails(inventoryDetails, token);
	}
	@PutMapping("/updateInventory")
	public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token) throws InventoryNotFoundException{
		
		return inventoryClient.updateInventoryDetails(inventoryDetails, token);
            
        
	}
	@DeleteMapping("/deleteInventory/{id}")
	public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException{
		
			return inventoryClient.deleteInventoryDetails(id, token);
	}
           

}
