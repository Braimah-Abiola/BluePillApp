package com.example.bluepill.HelperClasses.Recycler;

import android.graphics.drawable.Drawable;

public class CategoryHelperClass {

    Drawable drawable;
    int image;
    String title;

    public CategoryHelperClass(int image, String title, Drawable drawable) {
        this.image = image;
        this.title = title;
        this.drawable = drawable;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
