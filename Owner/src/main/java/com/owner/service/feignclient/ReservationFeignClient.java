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

import com.owner.service.exception.ReservationNotFoundException;
import com.owner.service.model.Reservation;



@FeignClient(name = "reservation-service", url = "http://localhost:8082/reservation")
public interface ReservationFeignClient {

	@GetMapping("/all")
	public ResponseEntity<List<Reservation>> showAllReservation(@RequestHeader("Authorization") String token);

	@GetMapping("/{id}")
	public ResponseEntity<Reservation> showById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) 
			throws ReservationNotFoundException;

	@PostMapping("/add")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation,@RequestHeader("Authorization") String token)
			throws ReservationNotFoundException;

	@PutMapping("/update")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation,@RequestHeader("Authorization") String token)
			throws ReservationNotFoundException;

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws ReservationNotFoundException;

}
