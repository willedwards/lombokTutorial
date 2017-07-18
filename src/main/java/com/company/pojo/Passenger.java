package com.company.pojo;

import lombok.Value;
import lombok.Builder;

import java.time.LocalDate;

@Value
@Builder
public class Passenger {

    String title;
    String firstname;
    String surname;
    boolean male;
    Passport passport;

    public boolean isAdult(){
        //ignore time zone for simplicity
        LocalDate now = LocalDate.now();
        LocalDate adultBirthday = (passport.dateOfBirth.plusYears(18));
        return now.isAfter(adultBirthday);
    }

}
