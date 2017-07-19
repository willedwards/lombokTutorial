package com.company.pojo;

import java.util.Arrays;

public class CreditCard {

    final byte[] clearCardNumber;
    final int expiryMonth;
    final int expiryYear;
    final int ccv;
    final String ownersName;

    public CreditCard(byte[] clearCardNumber, int expiryMonth, int expiryYear, int ccv, String ownersName) {
        this.clearCardNumber = clearCardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.ccv = ccv;
        this.ownersName = ownersName;
    }

    public byte[] getClearCardNumber() {
        return Arrays.copyOf(clearCardNumber,clearCardNumber.length);
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public int getCcv() {
        return ccv;
    }

    public String getOwnersName() {
        return ownersName;
    }
}
