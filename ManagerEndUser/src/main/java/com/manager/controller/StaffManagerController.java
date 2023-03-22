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

import com.manager.exception.StaffNotFoundException;
import com.manager.feignclient.StaffFiegnClient;
import com.manager.model.Staff;

@RestController
@RequestMapping("/manager")

public class StaffManagerController {
	@Autowired
	private StaffFiegnClient staffClient;

	@GetMapping("/allStaff")
	public ResponseEntity<List<Staff>> showAllStaff(@RequestHeader("Authorization") String token) {

		return staffClient.showAllStaff(token);
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<Staff> showRoomById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws StaffNotFoundException {

		return staffClient.showById(id,token);
	}

	@PostMapping("/addStaff")
	public ResponseEntity<Staff> addStaffDetails(@RequestBody Staff staffDetails,@RequestHeader("Authorization") String token) throws StaffNotFoundException {

		return staffClient.addStaffDetails(staffDetails,token);
	}

	@PutMapping("/updateStaff")
	public ResponseEntity<Staff> updateStaffDetails(@RequestBody Staff staffDetails,@RequestHeader("Authorization") String token) throws StaffNotFoundException {

		return staffClient.updateStaffDetails(staffDetails,token);
	}

	@DeleteMapping("/deleteStaff/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws StaffNotFoundException {

		return staffClient.deleteStaffDetails(id,token);
	}

}
