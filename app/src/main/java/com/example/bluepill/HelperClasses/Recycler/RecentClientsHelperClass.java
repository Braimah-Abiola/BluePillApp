package com.example.bluepill.HelperClasses.Recycler;

public class RecentClientsHelperClass {

    int image;
    String name, code, date, condition;

    public RecentClientsHelperClass(int image, String name, String code, String date, String condition) {
        this.image = image;
        this.name = name;
        this.code = code;
        this.date = date;
        this.condition = condition;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }


    public String getDate() {
        return date;
    }


    public String getCondition() {
        return condition;
    }

}
