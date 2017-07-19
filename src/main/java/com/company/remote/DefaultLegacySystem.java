package com.company.remote;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DefaultLegacySystem implements LegacySystem {

    private final FlightDetails flightDetails = new FlightDetails();
    private final Map<String,FlightDetails> flightsDB = new ConcurrentHashMap();

    public DefaultLegacySystem(){
        flightDetails.setSeatPrice(234);
        flightDetails.setId("LHR2JFK1");
        flightDetails.setSeatsAvailable(3);

        flightsDB.put(flightDetails.id,flightDetails);
    }

    public FlightDetails findById(String id) {
        return flightsDB.get(id);
    }
}
