package com.example.bluepill.HelperClasses.Recycler;

import android.graphics.drawable.Drawable;

public class PaymentHelperClass {

    int image;
    Drawable drawable;
    String cardHolder, expiryDate, cvv, cardNumber;

    public PaymentHelperClass(int image, Drawable drawable, String cvv, String cardHolder, String expiryDate, String cardNumber) {
        this.image = image;
        this.drawable = drawable;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }

    public int getImage() {
        return image;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
