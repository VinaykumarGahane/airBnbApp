package com.vinayGahane.airBnbApp.controller;

import com.vinayGahane.airBnbApp.dto.BookingDto;
import com.vinayGahane.airBnbApp.dto.BookingRequest;
import com.vinayGahane.airBnbApp.dto.GuestDto;
import com.vinayGahane.airBnbApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class HotelBookingController {

    private final BookingService bookingService;

    @PostMapping("/init")
    public ResponseEntity<BookingDto> initialiseBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.initialiseBooking(bookingRequest));
    }

    @PostMapping("/{bookingId}/addGuests")
    public ResponseEntity<BookingDto> addGuests(@PathVariable("bookingId") Long bookingId,
                                                @RequestBody List<GuestDto> guests
                                                ){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addGuests(bookingId,guests));
    }

}
