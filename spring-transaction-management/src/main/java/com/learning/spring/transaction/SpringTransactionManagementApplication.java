package com.learning.spring.transaction;

import com.learning.spring.transaction.dto.FlightBookingAcknowledgement;
import com.learning.spring.transaction.dto.FlightBookingRequest;
import com.learning.spring.transaction.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableTransactionManagement
public class SpringTransactionManagementApplication {

	@Autowired
	private BookingService service;


	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionManagementApplication.class, args);
	}

}
