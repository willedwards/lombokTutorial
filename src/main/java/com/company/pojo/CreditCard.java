package com.company.pojo;

import lombok.*;

@Value
@Builder
public class CreditCard {

    byte[] clearCardNumber;
    int expiryMonth;
    int expiryYear;
    int ccv;
    String ownersName;
}
