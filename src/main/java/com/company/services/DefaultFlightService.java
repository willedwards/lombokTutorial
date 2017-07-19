package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.FlightCriteria;
import com.company.pojo.Passenger;
import com.company.remote.DefaultLegacySystem;
import com.company.remote.FlightDetails;
import com.company.remote.LegacySystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Crappy implementation of a FlightService. Reflecting the start of real world workings.
 */
public class DefaultFlightService implements FlightService {

    private static final Logger log = LoggerFactory.getLogger(DefaultLegacySystem.class);

    private final Set<Passenger> passengersBookedOnLHR2JFK1 = new HashSet<>();

    private final LegacySystem legacySystem = new DefaultLegacySystem();

    @Override
    public String bookFlight(final FlightCriteria flightCriteria) throws FlightNotBookedException {

        FlightDetails flightDetails =  legacySystem.findById(flightCriteria.getFlight().getCode());

        Passenger passenger = flightCriteria.getPassenger();

        if(flightDetails == null){
            throw new FlightNotBookedException("flight not found");
        }

        if(flightDetails.getSeatsAvailable() == 0){
            throw new FlightNotBookedException("no seats left!");
        }

        if(!passenger.isAdult()){
            throw new FlightNotBookedException("an adult must book the flight");
        }

        if(flightCriteria.getFlight().getCode().equals("LHR2JFK1")){
            log.info(passenger.toString());
            passengersBookedOnLHR2JFK1.add(passenger);
            return "JFK001";
        }

        throw new FlightNotBookedException("contact support");
    }

    public Collection<Passenger> getAllPassengers(String flightCode){
        if(flightCode.equals("JFK001")){
            return passengersBookedOnLHR2JFK1;
        }

        return Collections.EMPTY_SET;
    }
}
