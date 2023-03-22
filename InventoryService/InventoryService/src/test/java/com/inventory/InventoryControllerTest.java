package com.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.inventory.controller.InventoryController;
import com.inventory.exception.InventoryNotFoundException;
import com.inventory.model.Inventory;
import com.inventory.service.InventoryAuthService;
import com.inventory.service.InventoryServiceImplementation;

@SpringBootTest
class InventoryControllerTest {

	@Autowired
	private InventoryController controller;

	@MockBean
	private InventoryServiceImplementation inventoryService;

	@MockBean
	private InventoryAuthService authService;
	List<Inventory> inventory = new ArrayList<>();

	String token = "token";

	@Test
	public void ShowAllInventoryTestController() throws InventoryNotFoundException {

		List<Inventory> inventory = new ArrayList<>();

		Inventory i = new Inventory();
		i.setInventoryCode(1);
		i.setInventoryType("Cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(500);

		inventory.add(i);

		when(inventoryService.showAllInventoryDetails()).thenReturn(inventory);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(1, controller. showAllinventoryDetails(token).getBody().size());
	}

	@Test
	public void ShowInventoryByIdControllerTest() throws InventoryNotFoundException {

		List<Inventory> inventory = new ArrayList<>();

		Inventory i = new Inventory();
		i.setInventoryCode(1);
		i.setInventoryType("Cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(500);

		inventory.add(i);

		when(inventoryService.showInventoryById(1)).thenReturn(i);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(i, controller.showInventoryDetailsById(1, token).getBody());
	}

	@Test
	public void addInventoryControllerTest() throws InventoryNotFoundException {

		Inventory i = new Inventory();
		i.setInventoryCode(1);
		i.setInventoryType("Cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(500);

		when(inventoryService.addInventoryDetails(i)).thenReturn(i);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(i, controller.addInventoryDetails(i, token).getBody());
	}

	@Test
	public void updateInventoryControllerTest() throws InventoryNotFoundException {

		Inventory i = new Inventory();
		i.setInventoryCode(1);
		i.setInventoryType("Cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(500);

		when(inventoryService.updateInventoryDetails(i)).thenReturn(i);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(i, controller.updateInventoryDetails(i, token).getBody());
	}

	@Test
	public void deleteInventoryControllerTest() throws InventoryNotFoundException {

		Inventory i = new Inventory();
		i.setInventoryCode(1);
		i.setInventoryType("Cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(500);

		when(inventoryService.deleteInventoryDetails(1)).thenReturn("Deleted Successfully");
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals("Deleted Successfully", controller.deleteInventoryDetails(1, token).getBody());
	}
}