package com.guestservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "reservation-service", url = "http://localhost:8082/reservation")
public interface ReservationFeignClient {

 

    @GetMapping("/roomprice/{roomType}")
    public String getPrice(@PathVariable("roomType") String roomType,@RequestHeader("Authorization") String token);

}
