package com.company.pojo;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class Flight {

    String code;
    LocalDateTime arrival;
    LocalDateTime departure;
    String departureAirportCode; //LHR
    String arrivalAirportCode; //JFK

}
