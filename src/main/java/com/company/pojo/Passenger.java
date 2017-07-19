package com.company.pojo;


import java.time.LocalDate;


public class Passenger {

    private final String title;
    private final String firstname;
    private final String surname;
    private final boolean  male;
    private final Passport passport;

    public Passenger(String title, String firstname, String surname, boolean male, Passport passport) {
        this.title = title;
        this.firstname = firstname;
        this.surname = surname;
        this.male = male;
        this.passport = passport;
    }

    public boolean isAdult(){
        //ignore time zone for simplicity
        LocalDate now = LocalDate.now();
        LocalDate adultBirthday = (passport.getDateOfBirth().plusYears(18));
        return now.isAfter(adultBirthday);
    }


}
