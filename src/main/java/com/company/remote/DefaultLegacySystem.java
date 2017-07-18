package com.company.remote;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DefaultLegacySystem implements LegacySystem {

    FlightDetails LHR2JFK1 = FlightDetails.builder().id("LHR2JFK1").seatPrice(234).seatsAvailable(3).build();
    FlightDetails LHR2JFK2 = FlightDetails.builder().id("LHR2JFK2").seatPrice(200).seatsAvailable(1).build();
    FlightDetails LHR2BEG = FlightDetails.builder().id("LHRBEG").seatPrice(199).seatsAvailable(1).build();

    //
    private final Map<String,FlightDetails> flightsDB = new ConcurrentHashMap(){{{
        put(LHR2JFK1.getId(),LHR2JFK1);
        put(LHR2JFK2.getId(),LHR2JFK2);
        put(LHR2BEG.getId(),LHR2BEG);
    }}};


    public FlightDetails findById(String id) {
        return flightsDB.get(id);
    }
}
