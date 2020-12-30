package com.connect;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String name;
    public String phno;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String phno) {
        this.name = name;
        this.phno = phno;
    }
}

/*DANGER-AHEAD 30-12-2020*/
