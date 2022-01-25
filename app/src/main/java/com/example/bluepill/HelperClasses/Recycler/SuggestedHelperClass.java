package com.example.bluepill.HelperClasses.Recycler;

public class SuggestedHelperClass {

    int image;
    String name, specialty;

    public SuggestedHelperClass(int image, String name, String specialty) {
        this.name = name;
        this.image = image;
        this.specialty = specialty;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

}
