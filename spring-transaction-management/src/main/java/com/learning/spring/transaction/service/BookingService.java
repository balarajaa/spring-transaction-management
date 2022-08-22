package com.learning.spring.transaction.service;

import com.learning.spring.transaction.dto.FlightBookingAcknowledgement;
import com.learning.spring.transaction.dto.FlightBookingRequest;
import com.learning.spring.transaction.entity.PassengerInfo;
import com.learning.spring.transaction.entity.PaymentInfo;
import com.learning.spring.transaction.repository.PassengerInfoRepository;
import com.learning.spring.transaction.repository.PaymentInfoRepository;
import com.learning.spring.transaction.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private PassengerInfoRepository repository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        repository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],passengerInfo);


    }
}
