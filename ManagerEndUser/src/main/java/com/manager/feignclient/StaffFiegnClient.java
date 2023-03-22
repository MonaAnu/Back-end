package com.manager.feignclient;

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

import com.manager.exception.StaffNotFoundException;
import com.manager.model.Staff;

@FeignClient(name="Staff-Service" , url="http://localhost:8085/staff")
public interface StaffFiegnClient {
	@GetMapping("/all")
    public ResponseEntity<List<Staff>> showAllStaff(@RequestHeader("Authorization") String token);

	@GetMapping("/{id}")
    public ResponseEntity<Staff> showById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws StaffNotFoundException;

	@PostMapping("/add")
	public ResponseEntity<Staff> addStaffDetails(@RequestBody Staff staffDetails,@RequestHeader("Authorization") String token) throws StaffNotFoundException;
	
	@PutMapping("/update")
	public ResponseEntity<Staff> updateStaffDetails(@RequestBody Staff staff,@RequestHeader("Authorization") String token) throws StaffNotFoundException;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws StaffNotFoundException;
	
}
