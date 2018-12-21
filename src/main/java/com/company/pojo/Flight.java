package com.company.pojo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Flight {
    String id;
    String code;
    LocalDateTime arrival;
    LocalDateTime departure;
    String departureAirportCode; //LHR
    String arrivalAirportCode; //JFK

}
