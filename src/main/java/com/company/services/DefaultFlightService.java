package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.FlightCriteria;
import com.company.pojo.Passenger;
import com.company.remote.DefaultLegacySystem;
import com.company.remote.FlightDetails;
import com.company.remote.LegacySystem;

import java.util.*;

public class DefaultFlightService implements FlightService {

    final LegacySystem legacySystem = new DefaultLegacySystem();
    final Set<Passenger> passengers = new HashSet<>();

    @Override
    public String bookFlight(final FlightCriteria flightCriteria)  {

        FlightDetails flightDetails =  legacySystem.findById(flightCriteria.getFlight().getCode());
        Passenger passenger = null;

        return "mo such flight";
    }

    @Override
    public Collection<Passenger> findAllPassengers(String flightCode) {
        if(flightCode.equals("JFK001")){
            return passengers;
        }
        return Collections.EMPTY_SET;
    }


}
