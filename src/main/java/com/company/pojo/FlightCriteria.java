package com.company.pojo;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class FlightCriteria {

    private Passenger passenger;
    private Flight flight;
    private CreditCard creditCard;

}
