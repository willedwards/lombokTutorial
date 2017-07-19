package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.FlightCriteria;
import com.company.pojo.Passenger;

import java.util.Collection;

public interface FlightService {

    /**
     *
     * @return bookingReference
     */
    String bookFlight(final FlightCriteria flightCriteria) throws FlightNotBookedException;


    Collection<Passenger> getAllPassengers(String flightCode);

}
