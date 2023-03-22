package com.guestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;
import com.guestservice.repository.GuestDetailsRepository;
import com.guestservice.service.GuestDetailsService;

@SpringBootTest
class GuestServiceApplicationTests {
	@Autowired
	private GuestDetailsService guestService;

	@MockBean
	private GuestDetailsRepository guestRepository;

	@Test
	public void ShowAllGuestTest() throws GuestNotFoundException {
		List<GuestDetails> guestdetails = new ArrayList<>();

		GuestDetails g = new GuestDetails();

		g.setGuestId(1);
		g.setName("Pravalika");
		g.setContact("97826735");
		g.setGender('f');
		g.setEmail("pravalika@gmail.com");
		g.setAddress("Waranagl");

		guestdetails.add(g);

		when(guestRepository.findAll()).thenReturn(guestdetails);
		assertEquals(1, guestService.showAllGuestDetails().size());
	}

	@Test
	public void ShowGuestByIdTest() throws GuestNotFoundException {
		GuestDetails g = new GuestDetails();

		g.setGuestId(1);
		g.setName("Pravalika");
		g.setContact("97826735");
		g.setGender('f');
		g.setEmail("pravalika@gmail.com");
		g.setAddress("Waranagl");

		Optional<GuestDetails> guest = Optional.of(g);

		when(guestRepository.findById(1)).thenReturn(guest);
		assertEquals(g, guestService.showGuestById(1));
	}

	@Test
	public void addGuestTest() throws GuestNotFoundException {

		GuestDetails g = new GuestDetails();

		g.setGuestId(1);
		g.setName("Pravalika");
		g.setContact("97826735");
		g.setGender('f');
		g.setEmail("pravalika@gmail.com");
		g.setAddress("Waranagl");

		when(guestRepository.insert(g)).thenReturn(g);
		assertEquals(g, guestService.addGuestDetails(g));
	}

	@Test
	public void updateFarmerTest() throws GuestNotFoundException {
		GuestDetails g1 = new GuestDetails();
		GuestDetails g2 = new GuestDetails();

		g1.setGuestId(1);
		g1.setName("Pravalika");
		g1.setContact("97826735");
		g1.setGender('f');
		g1.setEmail("pravalika@gmail.com");
		g1.setAddress("Waranagl");

		g2.setGuestId(1);
		g2.setName("Pravalika");
		g2.setContact("97826735");
		g2.setGender('f');
		g2.setEmail("pravalika@gmail.com");
		g2.setAddress("Waranagl");

		Optional<GuestDetails> guest = Optional.of(g1);

		when(guestRepository.findById(1)).thenReturn(guest);
		when(guestRepository.save(g2)).thenReturn(g2);
		assertEquals(g2, guestService.updateGuestDetails(g2));
	}

	@Test
	public void deleteGuestTest() throws GuestNotFoundException {
		GuestDetails g = new GuestDetails();

		g.setGuestId(1);
		g.setName("Pravalika");
		g.setContact("97826735");
		g.setGender('f');
		g.setEmail("pravalika@gmail.com");
		g.setAddress("Waranagl");

		Optional<GuestDetails> guest = Optional.of(g);
		when(guestRepository.findById(1)).thenReturn(guest);
		assertEquals("Guest with the id 1 Deleted Successfully!", guestService.deleteGuestDetails(1));
	}

}
