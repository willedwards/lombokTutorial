package com.company.services;

import com.company.exceptions.FlightNotBookedException;
import com.company.pojo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class FlightServiceTest {

    FlightService flightService = new DefaultFlightService();

    Flight flight = new Flight();

    CreditCard validCreditCard;

    @Before
    public void before() {
        flight.setArrival(LocalDateTime.of(2017, 12, 31, 0, 0));
        flight.setDeparture(LocalDateTime.of(2017, 12, 30, 20, 30));
        flight.setArrivalAirportCode("JFK");
        flight.setCode("LHR2JFK1");
        flight.setDepartureAirportCode("LHR");

        validCreditCard = new CreditCard("123456789123456".getBytes(), 11, 2017, 123, "Mr R Tucker");

    }

    @Test
    public void childRunsAwayFromHome_FailsDueToPassportAgeCheck()  {

        //given
        Passport tommysValidPassport = new Passport("023456789", 11, 2017, "Tommy Tucker",
                LocalDate.of(1978, 1, 3));


        Passenger tommy = new Passenger("mr", "tommy", "tucker", true, tommysValidPassport);


        //when
        FlightCriteria criteria = new FlightCriteria(tommy, flight, validCreditCard);

        //then
       try {
            flightService.bookFlight(criteria);
        } catch (FlightNotBookedException e) {
            assertEquals("an adult must book the flight", e.getMessage());
        }
    }


    @Test
    public void fatherCanBook_DueToPassportAgeCheck() throws FlightNotBookedException {

        //given
        Passport passport = new Passport("34456789", 3, 2018, "Ross tucker", LocalDate.of(1978, 1, 3));


        Passenger adultPassenger = new Passenger("mr", "ross", "tucker", true, passport);

        //when
        FlightCriteria criteria = new FlightCriteria(adultPassenger, flight, validCreditCard);

        //then
        assertEquals("JFK001", flightService.bookFlight(criteria));
    }

    @Test
    public void cannotBookFatherTwice() throws FlightNotBookedException {
        //given
        Passport passport = new Passport("34456789", 3, 2018, "Ross tucker", LocalDate.of(1978, 1, 3));


        Passenger adultPassenger = new Passenger("mr", "ross", "tucker", true, passport);

        //when
        FlightCriteria criteria = new FlightCriteria(adultPassenger, flight, validCreditCard);

        //then first booking
        assertEquals("JFK001", flightService.bookFlight(criteria));
        assertTrue(flightService.getAllPassengers("JFK001").size() == 1);

        //then second booking
        assertEquals("JFK001", flightService.bookFlight(criteria));
        assertTrue(flightService.getAllPassengers("JFK001").size() == 1);
    }
}
