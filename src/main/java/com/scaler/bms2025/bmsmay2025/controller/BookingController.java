package com.scaler.bms2025.bmsmay2025.controller;
import org.springframework.http.ResponseEntity;
import com.scaler.bms2025.bmsmay2025.exception.BookingCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.bms2025.bmsmay2025.model.Booking;
import com.scaler.bms2025.bmsmay2025.service.BookingServiceImpl;
import com.scaler.bms2025.dto.BookingResponseDTO;
import com.scaler.bms2025.dto.CreateBookingRequestDTO;
import com.scaler.bms2025.dto.UpdateBookingRequestDTO;

@RestController
public class BookingController {
    private BookingServiceImpl bookingService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public BookingResponseDTO getAllBookings(){
        return null;
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@RequestBody CreateBookingRequestDTO dto) {
        try {
            validateRequestDTO(dto);
            Booking createdBooking = bookingService.initiateBooking(dto.getSeatIds(), dto.getShowId(), dto.getUserId());
            // Optionally convert booking to DTO and return
            return ResponseEntity.ok(createdBooking);
        } catch (BookingCreationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Booking failed: " + e.getMessage());
        }
    }


    private void validateRequestDTO(CreateBookingRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateRequestDTO'");
    }

    @PutMapping("/booking")
    public void updateBooking(@RequestBody UpdateBookingRequestDTO updateBookingRequestDTO){

    }
    
}
