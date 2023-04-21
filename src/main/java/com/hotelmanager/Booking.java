package com.hotelmanager;

public class Booking {
    private Customer customer;
    private Room room;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Room getRoom(){
        return room;
    }
    public static void bookRoom(Customer customer, Room room) {
        Booking booking = new Booking(customer, room);
    }
}