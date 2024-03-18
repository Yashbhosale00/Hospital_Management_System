package com.example.i_hospital.models;

public class Item {
    private String title;
    private String value;
    private String date;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Constructor without image parameter
    public Item(String title, String value, String date) {
        this.title = title;
        this.value = value;
        this.date = date;
    }


}
