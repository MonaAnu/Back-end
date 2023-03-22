package com.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.reservation.controller.ReservationController;
import com.reservation.exception.ReservationNotFoundException;
import com.reservation.model.Reservation;
import com.reservation.service.ReservationAuthService;
import com.reservation.service.ReservationServiceImplementation;

@SpringBootTest
class ReservationControllerTest {

	@Autowired
	private ReservationController controller;

	@MockBean
	private ReservationServiceImplementation reservationService;

	@MockBean
	private ReservationAuthService authService;
	List<Reservation> reservation = new ArrayList<>();

	String token = "token";

	@Test
	public void ShowAllReservationTestController() throws ReservationNotFoundException {

		List<Reservation> reservation = new ArrayList<>();

		Reservation r = new Reservation();

		r.setReservationCode(1);
		r.setNumberOfAdult(2);
		r.setNumberOfChildren(1);
		r.setCheckIn("2022-12-01");
		r.setCheckOut("2022-12-03");
		r.setNumberOfNights(3);
		r.setRoomType("Deluxe");
		r.setName("Anusha");
		r.setEmailId("anu@10");
		r.setPhoneNumber("8939681133");
		r.setGender("Female");
		r.setAddress("No.10, Senthil nagar,Urappakkam");
		r.setStatus(true);
		r.setRate(1000);

		reservation.add(r);

		when(reservationService.showAllReservationDetails()).thenReturn(reservation);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(1, controller.showAllReservationDetails(token).getBody().size());
	}

	@Test
	public void ShowReservationByIdControllerTest() throws ReservationNotFoundException {

		List<Reservation> reservation = new ArrayList<>();

		Reservation r = new Reservation();

		r.setReservationCode(1);
		r.setNumberOfAdult(2);
		r.setNumberOfChildren(1);
		r.setCheckIn("2022-12-01");
		r.setCheckOut("2022-12-03");
		r.setNumberOfNights(3);
		r.setRoomType("Deluxe");
		r.setName("Anusha");
		r.setEmailId("anu@10");
		r.setPhoneNumber("8939681133");
		r.setGender("Female");
		r.setAddress("No.10, Senthil nagar,Urappakkam");
		r.setStatus(true);
		r.setRate(1000);

		reservation.add(r);

		when(reservationService.showReservationById(1)).thenReturn(r);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(r, controller.showReservationDetailsById(1, token).getBody());
	}

	@Test
	public void addReservationControllerTest() throws ReservationNotFoundException {

		Reservation r = new Reservation();

		r.setReservationCode(1);
		r.setNumberOfAdult(2);
		r.setNumberOfChildren(1);
		r.setCheckIn("2022-12-01");
		r.setCheckOut("2022-12-03");
		r.setNumberOfNights(3);
		r.setRoomType("Deluxe");
		r.setName("Anusha");
		r.setEmailId("anu@10");
		r.setPhoneNumber("8939681133");
		r.setGender("Female");
		r.setAddress("No.10, Senthil nagar,Urappakkam");
		r.setStatus(true);
		r.setRate(1000);

		when(reservationService.addReservation(r)).thenReturn(r);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(r, controller.addReservation(r, token).getBody());
	}

	@Test
	public void updateReservationControllerTest() throws ReservationNotFoundException {

		Reservation r = new Reservation();

		r.setReservationCode(1);
		r.setNumberOfAdult(2);
		r.setNumberOfChildren(1);
		r.setCheckIn("2022-12-01");
		r.setCheckOut("2022-12-03");
		r.setNumberOfNights(3);
		r.setRoomType("Deluxe");
		r.setName("Anusha");
		r.setEmailId("anu@10");
		r.setPhoneNumber("8939681133");
		r.setGender("Female");
		r.setAddress("No.10, Senthil nagar,Urappakkam");
		r.setStatus(true);
		r.setRate(1000);

		when(reservationService.updateReservation(r)).thenReturn(r);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(r, controller.updateReservation(r, token).getBody());
	}

	@Test
	public void deleteReservationControllerTest() throws ReservationNotFoundException {
		Reservation r = new Reservation();

		r.setReservationCode(1);
		r.setNumberOfAdult(2);
		r.setNumberOfChildren(1);
		r.setCheckIn("2022-12-01");
		r.setCheckOut("2022-12-03");
		r.setNumberOfNights(3);
		r.setRoomType("Deluxe");
		r.setName("Anusha");
		r.setEmailId("anu@10");
		r.setPhoneNumber("8939681133");
		r.setGender("Female");
		r.setAddress("No.10, Senthil nagar,Urappakkam");
		r.setStatus(true);
		r.setRate(1000);

		when(reservationService.deleteReservation(1)).thenReturn("Deleted Successfully");
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals("Deleted Successfully", controller.deleteReservation(1, token).getBody());
	}
}
