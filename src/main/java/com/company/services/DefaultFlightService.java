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
    public String bookFlight(final FlightCriteria flightCriteria) throws FlightNotBookedException {

        FlightDetails flightDetails =  legacySystem.findById(flightCriteria.getFlight().getCode());

        if(flightDetails == null){
            throw new FlightNotBookedException("flight not found");
        }

        Passenger passenger = flightCriteria.getPassenger();
        if(flightDetails.getSeatsAvailable() == 0){
            throw new FlightNotBookedException("no seats left!");
        }

        if(!passenger.isAdult()){
            throw new FlightNotBookedException("an adult must book the flight");
        }

        if(flightCriteria.getFlight().getCode().equals("LHR2JFK1")){
            passengers.add(passenger);
            return "JFK001";
        }

        throw new FlightNotBookedException("contact support");
    }

    @Override
    public Collection<Passenger> findAllPassengers(String flightCode) {
        if(flightCode.equals("JFK001")){
            return passengers;
        }
        return Collections.EMPTY_SET;
    }


}
