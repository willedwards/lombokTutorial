package com.company.remote;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class FlightDetails {

    String id;
    int seatsAvailable;
    double seatPrice;

}
