package com.company.pojo;

import java.time.LocalDate;


public class Passport {

    public Passport(String number, int expiryMonth, int expiryYear, String exactName, LocalDate dateOfBirth) {
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.exactName = exactName;
        this.dateOfBirth = dateOfBirth;
    }

    private final String number;
    private final  int expiryMonth;
    private final  int expiryYear;
    private final  String exactName;
    private final  LocalDate dateOfBirth;

    public String getNumber() {
        return this.number;
    }

    public int getExpiryMonth() {
        return this.expiryMonth;
    }

    public int getExpiryYear() {
        return this.expiryYear;
    }

    public String getExactName() {
        return this.exactName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Passport)) return false;
        final Passport other = (Passport) o;
        final Object this$number = this.number;
        final Object other$number = other.number;
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        if (this.expiryMonth != other.expiryMonth) return false;
        if (this.expiryYear != other.expiryYear) return false;
        final Object this$exactName = this.exactName;
        final Object other$exactName = other.exactName;
        if (this$exactName == null ? other$exactName != null : !this$exactName.equals(other$exactName)) return false;
        final Object this$dateOfBirth = this.dateOfBirth;
        final Object other$dateOfBirth = other.dateOfBirth;
        if (this$dateOfBirth == null ? other$dateOfBirth != null : !this$dateOfBirth.equals(other$dateOfBirth))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $number = this.number;
        result = result * PRIME + ($number == null ? 0 : $number.hashCode());
        result = result * PRIME + this.expiryMonth;
        result = result * PRIME + this.expiryYear;
        final Object $exactName = this.exactName;
        result = result * PRIME + ($exactName == null ? 0 : $exactName.hashCode());
        final Object $dateOfBirth = this.dateOfBirth;
        result = result * PRIME + ($dateOfBirth == null ? 0 : $dateOfBirth.hashCode());
        return result;
    }

}
