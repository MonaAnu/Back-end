package com.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.reservation.exception.ReservationNotFoundException;
import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;
import com.reservation.service.ReservationService;

@SpringBootTest
class ReservationServiceApplicationTests {

	@Autowired
    private ReservationService service;

 

 

    @MockBean
    private ReservationRepository reservationRepository;

 

    @Test
    public void ShowAllReservationTest() throws ReservationNotFoundException {
        List<Reservation>reservation = new ArrayList<>();
        Reservation r = new Reservation();

 

        r.setReservationCode(1);
        r.setNumberOfAdult(2);
        r.setNumberOfChildren(2);
        r.setCheckIn("2022-12-01");
        r.setCheckOut("2022-12-03");
        r.setNumberOfNights(3);
        r.setName("Vasavi");
        r.setEmailId("vasavi@123");
        r.setPhoneNumber("7812883396");
        r.setGender("female");
        r.setAddress("Chambers Colony,Chromepet");
        r.setStatus(true);
        r.setRate(1500);

 

 

    
        reservation.add(r);

 

 

        when(reservationRepository.findAll()).thenReturn(reservation);
        assertEquals(1, service.showAllReservationDetails().size());
    }

 

    @Test
    public void ShowReservationByIdTest() throws ReservationNotFoundException {

 

        Reservation r = new Reservation();

 

        r.setReservationCode(1);
        r.setNumberOfAdult(2);
        r.setNumberOfChildren(2);
        r.setCheckIn("2022-12-01");
        r.setCheckOut("2022-12-03");
        r.setNumberOfNights(3);
        r.setRoomType("Special Suite");
        r.setName("vasavi");
        r.setEmailId("vasavi@123");
        r.setPhoneNumber("7812883396");
        r.setGender("female");
        r.setAddress("Chambers Colony,Chromepet");
        r.setStatus(true);
        r.setRate(1500);

 


           Optional<Reservation> room = Optional.of(r);

 

           when(reservationRepository.findById(1)).thenReturn(room);
            assertEquals(r, service.showReservationById(1));
        }

 

    @Test
    public void addReservationTest() throws ReservationNotFoundException {

 

        Reservation r = new Reservation();

 

        r.setReservationCode(1);
        r.setNumberOfAdult(2);
        r.setNumberOfChildren(2);
        r.setCheckIn("2022-12-01");
        r.setCheckOut("2022-12-03");
        r.setNumberOfNights(3);
        r.setRoomType("Special Suite");
        r.setName("vasavi");
        r.setEmailId("vasavi@123");
        r.setPhoneNumber("7812883396");
        r.setGender("female");
        r.setAddress("Chambers Colony,Chromepet");
        r.setStatus(true);
        r.setRate(1500);

 


        when(reservationRepository.insert(r)).thenReturn(r);
        assertEquals(r, service.addReservation(r));

 

    }

 

    @Test
    public void updateReservationTest() throws ReservationNotFoundException {

 

        Reservation r1 = new Reservation();
        Reservation r2 = new Reservation();

 

        r1.setReservationCode(1);
        r1.setNumberOfAdult(2);
        r1.setNumberOfChildren(2);
        r1.setCheckIn("2022-12-01");
        r1.setCheckOut("2022-12-03");
        r1.setNumberOfNights(3);
        r1.setRoomType("Special Suite");
        r1.setName("vasavi");
        r1.setEmailId("vasavi@123");
        r1.setPhoneNumber("7812883396");
        r1.setGender("female");
        r1.setAddress("Chambers Colony,Chromepet");
        r1.setStatus(true);
        r1.setRate(1500);

 

        r2.setReservationCode(1);
        r2.setNumberOfAdult(2);
        r2.setNumberOfChildren(1);
        r2.setCheckIn("2022-12-01");
        r2.setCheckOut("2022-12-03");
        r2.setNumberOfNights(3);
        r2.setRoomType("Special Suite");
        r2.setName("vasavi");
        r2.setEmailId("vasavi@123");
        r2.setPhoneNumber("7812883396");
        r2.setGender("female");
        r2.setAddress("Chambers Colony,Chromepet");
        r2.setStatus(true);
        r2.setRate(1500);

 

 

    
           Optional<Reservation> room = Optional.of(r1);

 

           when(reservationRepository.findById(1)).thenReturn(room);
            when(reservationRepository.save(r2)).thenReturn(r2);
            assertEquals(r2, service.updateReservation(r2));
        }

 

    @Test
    public void deleteReservationTest() throws ReservationNotFoundException {

 

        Reservation r = new Reservation();

 

        r.setReservationCode(1);
        r.setNumberOfAdult(2);
        r.setNumberOfChildren(2);
        r.setCheckIn("2022-12-01");
        r.setCheckOut("2022-12-03");
        r.setNumberOfNights(3);
        r.setRoomType("Special Suite");
        r.setName("vasavi");
        r.setEmailId("vasavi@123");
        r.setPhoneNumber("7812883396");
        r.setGender("female");
        r.setAddress("Chambers Colony,Chromepet");
        r.setStatus(true);
        r.setRate(1500);

 

        Optional<Reservation> room = Optional.of(r);
        when(reservationRepository.findById(1)).thenReturn(room);
        assertEquals("Reservation with the 1 Deleted Successfully!", service.deleteReservation(1));
    }

 

}


