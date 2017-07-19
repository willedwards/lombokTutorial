package com.company.pojo;




public class FlightCriteria {

    private final Passenger passenger;
    private final Flight flight;
    private final CreditCard creditCard;

    public FlightCriteria(Passenger passenger, Flight flight, CreditCard creditCard) {
        this.passenger = passenger;
        this.flight = flight;
        this.creditCard = creditCard;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }


    public CreditCard getCreditCard() {
        return creditCard;
    }

}
