package com.example.bluepill.Payment;

public class SpinnerItem {
    private String mCardName;
    private int mCardImage;

    //Hooks

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
