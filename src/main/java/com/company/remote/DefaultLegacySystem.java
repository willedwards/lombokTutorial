package com.company.remote;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DefaultLegacySystem implements LegacySystem {

    FlightDetails LHR2JFK1 = FlightDetails.builder().id("LHR2JFK1").seatPrice(234).seatsAvailable(3).build();
    FlightDetails LHR2JFK2 = FlightDetails.builder().id("LHR2JFK2").seatPrice(200).seatsAvailable(1).build();
    FlightDetails LHR2BEG = FlightDetails.builder().id("LHRBEG").seatPrice(199).seatsAvailable(1).build();
    FlightDetails LHR2INN = FlightDetails.builder().id("LHRINN").seatPrice(199).seatsAvailable(0).build();

    private final Map<String,FlightDetails> flightsDB = new ConcurrentHashMap();

        //
    public DefaultLegacySystem(){
        flightsDB.put(LHR2JFK1.getId(),LHR2JFK1);
        flightsDB.put(LHR2JFK2.getId(),LHR2JFK2);
        flightsDB.put(LHR2BEG.getId(),LHR2BEG);
        flightsDB.put(LHR2INN.getId(),LHR2INN);
    }


    public FlightDetails findById(String id) {
        return flightsDB.get(id);
    }
}
