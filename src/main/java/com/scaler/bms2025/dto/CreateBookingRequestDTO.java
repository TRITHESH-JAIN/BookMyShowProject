package com.scaler.bms2025.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateBookingRequestDTO {
    private long userId;
    private List<Long> seatIds;
    private long showId; 
}
