package com.learning.spring.transaction.dto;

import com.learning.spring.transaction.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
