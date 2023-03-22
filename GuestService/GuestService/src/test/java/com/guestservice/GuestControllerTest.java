package com.guestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.guestservice.Controller.GuestDetailsController;
import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;
import com.guestservice.service.GuestAuthService;
import com.guestservice.service.GuestDetailsServiceImplementation;

@SpringBootTest
class GuestControllerTest {

	@Autowired
	private GuestDetailsController controller;

	@MockBean
	private GuestDetailsServiceImplementation guestService;

	@MockBean
	private GuestAuthService authService;
	List<GuestDetails> inventory = new ArrayList<>();

	String token = "token";

	@Test
	public void ShowAllGuestTestController() throws GuestNotFoundException {

		List<GuestDetails> guest = new ArrayList<>();

		GuestDetails g = new GuestDetails();
		g.setGuestId(1);
		g.setName("Gomathi");
		g.setContact("7890123457");
		g.setGender('F');
		g.setEmail("goravi@17");
		g.setAddress("Chennai, Tamilnadu");

		guest.add(g);

		when(guestService.showAllGuestDetails()).thenReturn(guest);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(1, controller.showAllGuestDetails(token).getBody().size());
	}

	@Test
	public void ShowGuestByIdControllerTest() throws GuestNotFoundException {

		List<GuestDetails> guest = new ArrayList<>();

		GuestDetails g = new GuestDetails();
		g.setGuestId(1);
		g.setName("Gomathi");
		g.setContact("7890123457");
		g.setGender('F');
		g.setEmail("goravi@17");
		g.setAddress("Chennai, Tamilnadu");

		guest.add(g);

		when(guestService.showGuestById(1)).thenReturn(g);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(g, controller.showGuestDetailsById(1, token).getBody());
	}

	@Test
	public void addGuestControllerTest() throws GuestNotFoundException {

		GuestDetails g = new GuestDetails();
		g.setGuestId(1);
		g.setName("Gomathi");
		g.setContact("7890123457");
		g.setGender('F');
		g.setEmail("goravi@17");
		g.setAddress("Chennai, Tamilnadu");

		when(guestService.addGuestDetails(g)).thenReturn(g);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(g, controller.addGuestDetails(g, token).getBody());
	}

	@Test
	public void updateGuestControllerTest() throws GuestNotFoundException {

		GuestDetails g = new GuestDetails();
		g.setGuestId(1);
		g.setName("Gomathi");
		g.setContact("7890123457");
		g.setGender('F');
		g.setEmail("goravi@17");
		g.setAddress("Chennai, Tamilnadu");

		when(guestService.updateGuestDetails(g)).thenReturn(g);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(g, controller.updateGuestDetails(g, token).getBody());
	}

	@Test
	public void deleteGuestControllerTest() throws GuestNotFoundException {

		GuestDetails g = new GuestDetails();
		g.setGuestId(1);
		g.setName("Gomathi");
		g.setContact("7890123457");
		g.setGender('F');
		g.setEmail("goravi@17");
		g.setAddress("Chennai, Tamilnadu");

		when(guestService.deleteGuestDetails(1)).thenReturn("Deleted Successfully");
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals("Deleted Successfully", controller.deleteGuestDetails(1, token).getBody());
	}
}
