package com.example.manhinhungdung.models;

public class Seat {
    private String seatNumber123;
    private boolean isBooked123;
    private boolean isSelected123;

    public Seat(String seatNumber123, boolean isBooked123) {
        this.seatNumber123 = seatNumber123;
        this.isBooked123 = isBooked123;
        this.isSelected123 = false;
    }

    public String getSeatNumber() {
        return seatNumber123;
    }

    public boolean isBooked() {
        return isBooked123;
    }

    public boolean isSelected() {
        return isSelected123;
    }

    public void setSelected(boolean selected123) {
        this.isSelected123 = selected123;
    }
}
