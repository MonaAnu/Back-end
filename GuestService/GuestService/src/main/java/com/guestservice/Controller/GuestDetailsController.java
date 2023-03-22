package com.guestservice.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.feignclient.ReservationFeignClient;
import com.guestservice.model.GuestDetails;
import com.guestservice.service.GuestAuthService;
import com.guestservice.service.GuestDetailsServiceImplementation;

@RestController
@RequestMapping("/guest")
public class GuestDetailsController {

	@Autowired
	private GuestDetailsServiceImplementation service;

	@Autowired
	private GuestAuthService guestAuthService;

	Logger log = LoggerFactory.getLogger(GuestDetailsController.class);
	@Autowired
	private ReservationFeignClient reservationClient;

	@GetMapping("/roomprice/{roomType}")
	public String getPrice(@PathVariable("roomType") String roomType, @RequestHeader("Authorization") String token) {
		return reservationClient.getPrice(roomType, token);
	}

	@GetMapping("/all")
	public ResponseEntity<List<GuestDetails>> showAllGuestDetails(@RequestHeader("Authorization") String token) {
		try {
			if (guestAuthService.isSessionValid(token)) {
				List<GuestDetails> guestDetails = service.showAllGuestDetails();
				if (guestDetails.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				}
				log.debug("Guest are {}", guestDetails);
				return new ResponseEntity<>(guestDetails, HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<GuestDetails> showGuestDetailsById(@PathVariable("id") int id,
			@RequestHeader("Authorization") String token) throws GuestNotFoundException {
		try {
			if (guestAuthService.isSessionValid(token)) {

				GuestDetails guestDetails = service.showGuestById(id);
				if (guestDetails != null) {
					log.debug("Guest Details: {}", guestDetails);
					return new ResponseEntity<>(guestDetails, HttpStatus.OK);
				} else
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	@PostMapping("/addguest")
	public ResponseEntity<GuestDetails> addGuestDetails(@RequestBody GuestDetails guestDetails,
			@RequestHeader("Authorization") String token) throws GuestNotFoundException {
		try {
			if (guestAuthService.isSessionValid(token)) {
				GuestDetails guest = service.addGuestDetails(guestDetails);
				if (guest != null) {
					log.debug("Guest Details: {}", guest);
					return new ResponseEntity<>(guest, HttpStatus.OK);
				} else
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	@PutMapping("/updateguest")
	public ResponseEntity<GuestDetails> updateGuestDetails(@RequestBody GuestDetails guestDetails,
			@RequestHeader("Authorization") String token) throws GuestNotFoundException {
		try {
			if (guestAuthService.isSessionValid(token)) {
				GuestDetails guest = service.updateGuestDetails(guestDetails);
				if (guest != null) {
					log.debug("Guest Details: {}", guest);
					return new ResponseEntity<>(guest, HttpStatus.CREATED);
				}
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	@DeleteMapping("/deleteguest/{id}")
	public ResponseEntity<String> deleteGuestDetails(@PathVariable("id") int id,
			@RequestHeader("Authorization") String token) throws GuestNotFoundException {
		try {
			if (guestAuthService.isSessionValid(token)) {
				service.deleteGuestDetails(id);
				return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

}
