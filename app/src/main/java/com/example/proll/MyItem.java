package com.example.proll;

public class MyItem {
    private String text;
    private int imageResId;

    public MyItem(String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }

    public MyItem(String text) {
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }
}
