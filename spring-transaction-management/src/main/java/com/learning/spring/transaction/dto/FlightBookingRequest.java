package com.learning.spring.transaction.dto;

import com.learning.spring.transaction.entity.PassengerInfo;
import com.learning.spring.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
       private PassengerInfo passengerInfo;

       private PaymentInfo paymentInfo;
}
