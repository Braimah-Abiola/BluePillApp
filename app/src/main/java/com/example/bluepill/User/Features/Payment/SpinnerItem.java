package com.example.bluepill.User.Features.Payment;

public class SpinnerItem {
    private final String mCardName;
    private final int mCardImage;

    public SpinnerItem(String cardName, int cardImage) {
        mCardImage = cardImage;
        mCardName = cardName;
    }

    public String getCardName(){
        return mCardName;
    }

    public int getCardImage(){
        return mCardImage;
    }

}
