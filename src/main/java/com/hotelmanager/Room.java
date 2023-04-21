package com.hotelmanager;

public class Room {
    private Property property;
    private int status;

    public Room(Property property, int status) {
        this.property = property;
        this.status = status;
    }

    public Property getProperty() {
        return property;
    }

    public void setRoom(Property property) {
        this.property = property;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}