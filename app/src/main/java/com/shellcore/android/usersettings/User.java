package com.shellcore.android.usersettings;

/**
 * Created by MOGC on 03/01/2018.
 */

public class User {

    // Constants
    public static final String BUILDING_KEY = "building";
    public static final String FLOOR_KEY = "floor";
    public static final String DESK_KEY = "desk";
    public static final String PHONE_KEY = "phone";
    public static final String EMAIL_KEY = "email";

    // Variables
    private static String building;
    private static String floor;
    private static String desk;
    private static String phone;
    private static String email;

    private static User user = new User();

    public static User getSharedInstance() {
        return user;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        User.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        User.floor = floor;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        User.desk = desk;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        User.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        User.email = email;
    }
}
