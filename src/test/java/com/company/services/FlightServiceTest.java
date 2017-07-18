package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.*;
import com.company.remote.LegacySystem;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


public class FlightServiceTest {

    FlightService flightService = new DefaultFlightService();


    private Flight flight;
    private Passenger passenger;
    private CreditCard creditCard;
    private FlightCriteria criteria;

    @Test
    public void childRunsAwayFromHome_FailsDueToPassportAgeCheck() throws Exception {
        //given
        weHaveAValidChildWithPassport();

        weHaveAFlightWithSeats();

        weHaveAValidCreditCard();

        //when
        weBuildTheCriteria();

        //then
        try {
            flightService.bookFlight(criteria);
            fail();
        } catch (FlightNotBookedException e) {
            assertEquals("an adult must book the flight", e.getMessage());
        }
    }

    private void weHaveAValidChildWithPassport() {
        Passport tommysValidPassport = Passport.builder()
                .exactName("tommy tucker")
                .expiryMonth(9)
                .expiryYear(2017)
                .dateOfBirth(LocalDate.of(2001, 11, 30))
                .number("023456789")
                .build();

        passenger = Passenger.builder()
                .firstname("tommy")
                .surname("tucker")
                .title("mr")
                .passport(tommysValidPassport)
                .build();

    }

    @Test
    public void fatherCanBook_DueToPassportAgeCheck() throws Exception {

        //given
        weHaveAValidAdultWithPassport();

        weHaveAFlightWithSeats();

        weHaveAValidCreditCard();

        //when
        weBuildTheCriteria();

        //then
        assertEquals("JFK001",flightService.bookFlight(criteria));
    }

    private void weBuildTheCriteria() {
        criteria = FlightCriteria.builder().creditCard(creditCard)
                .flight(flight)
                .passenger(passenger).build();
    }

    private void weHaveAValidCreditCard() {
        creditCard = CreditCard.builder().clearCardNumber("123456789123456".getBytes())
                .ccv(123)
                .expiryMonth(9)
                .expiryYear(2019)
                .ownersName("Mr R Tucker")
                .build();
    }

    private void weHaveAFlightWithSeats() {
        flight = Flight.builder().arrival(LocalDateTime.of(2017,12,31,0,0))
                .departure(LocalDateTime.of(2017,12,30,20,30))
                .arrivalAirportCode("JFK")
                .code("LHR2JFK1")
                .departureAirportCode("LHR")
                .build();


    }

    private void weHaveAValidAdultWithPassport() {

        Passport  passport = Passport.builder()
                .exactName("Ross tucker")
                .expiryMonth(3)
                .expiryYear(2018)
                .dateOfBirth(LocalDate.of(1978, 1, 3))
                .number("34456789")
                .build();

        passenger = Passenger.builder()
                .firstname("ross")
                .surname("tucker")
                .title("mr")
                .passport(passport)
                .build();
    }


}
