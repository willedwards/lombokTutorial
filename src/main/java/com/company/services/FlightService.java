package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.FlightCriteria;

public interface FlightService {

    /**
     *
     * @return bookingReference
     */
    String bookFlight(final FlightCriteria flightCriteria) throws FlightNotBookedException;


}
