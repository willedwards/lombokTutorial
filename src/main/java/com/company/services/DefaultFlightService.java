package com.company.services;

import com.company.exceptions.CreditCardException;
import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.CreditCard;
import com.company.pojo.FlightCriteria;
import com.company.remote.DefaultLegacySystem;
import com.company.remote.FlightDetails;
import com.company.remote.LegacySystem;

public class DefaultFlightService implements FlightService {

    final LegacySystem legacySystem = new DefaultLegacySystem();

    @Override
    public String bookFlight(final FlightCriteria flightCriteria) throws FlightNotBookedException {

        FlightDetails flightDetails =  legacySystem.findById(flightCriteria.getFlight().getCode());

        if(flightDetails == null){
            throw new FlightNotBookedException("flight not found");
        }

        if(flightDetails.getSeatsAvailable() == 0){
            throw new FlightNotBookedException("no seats left!");
        }

        if(!flightCriteria.getPassenger().isAdult()){
            throw new FlightNotBookedException("an adult must book the flight");
        }

        try {
            takePayment(flightCriteria.getCreditCard());
        }catch(CreditCardException e){
            throw new FlightNotBookedException(e.getMessage());
        }

        if(flightCriteria.getFlight().getCode().equals("LHR2JFK1")){
            return "JFK001";
        }

        if(flightCriteria.getFlight().getCode().equals("LHR2JFK2")){
            return "JFK002";
        }

        if(flightCriteria.getFlight().getCode().equals("LHRBEG")){
            return "BEG980";
        }

        throw new FlightNotBookedException("contact support");
    }

    private void takePayment(CreditCard creditCard) throws CreditCardException {
        //payment provider autowired in
        if((creditCard.getExpiryMonth() < 7) && (creditCard.getExpiryYear() < 2017)){
            throw new CreditCardException("card has expired");
        }
    }
}
