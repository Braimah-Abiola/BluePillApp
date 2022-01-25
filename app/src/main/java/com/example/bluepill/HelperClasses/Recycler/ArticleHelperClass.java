package com.example.bluepill.HelperClasses.Recycler;

public class ArticleHelperClass {

    int image;
    String title, author, info;

    public ArticleHelperClass(int image, String title, String author, String info) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getInfo() {
        return info;
    }
}
