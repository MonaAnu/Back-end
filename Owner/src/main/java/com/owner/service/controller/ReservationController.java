package com.owner.service.controller;

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
import com.owner.service.exception.ReservationNotFoundException;
import com.owner.service.feignclient.ReservationFeignClient;
import com.owner.service.model.Reservation;

@RestController
@RequestMapping("/owner")
public class ReservationController {
	@Autowired
	private ReservationFeignClient reservationClient;

	@GetMapping("/allres")
	public ResponseEntity<List<Reservation>> showAllReservation(@RequestHeader("Authorization") String token) {
		return reservationClient.showAllReservation(token);
	}

	@GetMapping("/res/{id}")
	public ResponseEntity<Reservation> showReservationById(@PathVariable("id") int id,@RequestHeader("Authorization") String token)
			throws ReservationNotFoundException {

		return reservationClient.showById(id, token);

	}

	@PostMapping("/addreservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation,@RequestHeader("Authorization") String token)
			throws ReservationNotFoundException {

		return reservationClient.addReservation(reservation, token);

	}

	@PutMapping("/updatereservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation,@RequestHeader("Authorization") String token)
			throws ReservationNotFoundException {

		return reservationClient.updateReservation(reservation, token);

	}

	@DeleteMapping("/deleteres/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws ReservationNotFoundException {

		return reservationClient.deleteReservation(id, token);

	}

}
