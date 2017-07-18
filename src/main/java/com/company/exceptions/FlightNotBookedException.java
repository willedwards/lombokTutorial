package com.company.exceptions;

public class FlightNotBookedException extends Exception {

    public FlightNotBookedException(String reason){
        super(reason);
    }
}
