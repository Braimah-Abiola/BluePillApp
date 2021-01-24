package com.example.bluepill.HelperClasses.DashboardAdapter;

public class CategoryHelperClass {

    int image, background;
    String title;

    public CategoryHelperClass(int image, String title, int background) {
        this.image = image;
        this.title = title;
        this.background = background;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getBackground() {
        return background;
    }
}
