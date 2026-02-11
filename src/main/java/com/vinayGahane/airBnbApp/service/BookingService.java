package com.vinayGahane.airBnbApp.service;

import com.vinayGahane.airBnbApp.dto.BookingDto;
import com.vinayGahane.airBnbApp.dto.BookingRequest;
import com.vinayGahane.airBnbApp.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
