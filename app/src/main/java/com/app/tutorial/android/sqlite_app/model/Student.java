package com.app.tutorial.android.sqlite_app.model;

import java.io.Serializable;

/**
 * Created by pranishres on 11/10/16.
 * We need to extend Serializable while sending Student object data from main activity to
 * student_list where we show list of student data via parameter. 
 */

public class Student implements Serializable{

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
