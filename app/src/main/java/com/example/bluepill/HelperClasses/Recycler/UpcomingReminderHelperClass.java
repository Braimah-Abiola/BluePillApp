package com.example.bluepill.HelperClasses.Recycler;

public class UpcomingReminderHelperClass {

    String title, desc, type, time;

    public UpcomingReminderHelperClass(String title, String desc, String type, String time) {
        this.title = title;
        this.desc = desc;
        this.type = type;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }
}

