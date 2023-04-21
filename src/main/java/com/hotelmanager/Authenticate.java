package com.hotelmanager;

public class Authenticate {
    private String username;
    private String password;

    public void changePassword(String password) {
        this.password = password;
    }

    public boolean checkLogin(String username, String password) {
        if (this.username == username && this.password == password) {
            return true;
        }
        return false;
    }
}
