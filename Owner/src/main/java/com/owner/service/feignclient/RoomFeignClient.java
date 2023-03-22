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

import com.owner.service.exception.RoomNotFoundException;
import com.owner.service.model.Room;



@FeignClient(name="RoomService" , url="http://localhost:8084/rooms")
public interface RoomFeignClient {
	 @GetMapping("/all")
	    public ResponseEntity<List<Room>> showAllRoom(@RequestHeader("Authorization") String token);

	   @GetMapping("/{id}")
	    public ResponseEntity<Room> showById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException;


	    @PostMapping("/addroom")
		public ResponseEntity<Room> addRoomDetails(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException;
			
		
	    @PutMapping("/updateroom")
		public ResponseEntity<Room> updateRoomDetails(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException;
		
	    @DeleteMapping("/deleteroom/{id}")
		public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException;
		
	}



