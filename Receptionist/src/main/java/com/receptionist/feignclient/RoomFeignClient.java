package com.receptionist.feignclient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.receptionist.model.Room;
import com.receptionist.exception.RoomNotFoundException;

@FeignClient(name="RoomService", url="http://localhost:8084/rooms")
public interface RoomFeignClient {
							
			@GetMapping("/all")
			public ResponseEntity<List<Room>> showAllRoom(@RequestHeader("Authorization") String token);
			
			@GetMapping("/{id}")
			public ResponseEntity<Room> showRoomDetailsById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException; 
}
