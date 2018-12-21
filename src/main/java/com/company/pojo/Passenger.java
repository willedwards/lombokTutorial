package com.company.pojo;

import lombok.Value;
import lombok.Builder;

import java.time.LocalDate;

@Value
@Builder
public class Passenger {

    private String title;
    private String firstname;
    private String surname;
    private boolean male;
    private Passport passport;

    public boolean isAdult(){
        //ignore time zone for simplicity
        LocalDate now = LocalDate.now();
        LocalDate adultBirthday = (passport.dateOfBirth.plusYears(18));
        return now.isAfter(adultBirthday);
    }

}
