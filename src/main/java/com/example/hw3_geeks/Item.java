package com.example.hw3_geeks;

public class Item {
    private final String text;
    private final int imageResId;

    public Item(String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }

    public String getText() {
        return text;
    }

    public int getImageResId() {
        return imageResId;
    }
}
