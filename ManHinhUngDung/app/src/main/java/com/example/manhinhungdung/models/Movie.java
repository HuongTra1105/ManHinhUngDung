package com.example.manhinhungdung.models;

public class Movie {
    private String title;
    private String info;
    private int posterResId; // ảnh resource (demo), thực tế có thể dùng URL

    public Movie(String title, String info, int posterResId) {
        this.title = title;
        this.info = info;
        this.posterResId = posterResId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getPosterResId() {
        return posterResId;
    }
}
