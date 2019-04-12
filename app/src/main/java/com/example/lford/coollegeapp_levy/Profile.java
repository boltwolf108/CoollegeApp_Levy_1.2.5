package com.example.lford.coollegeapp_levy;

import java.util.Date;

public class Profile {

    String lastName;
    String firstName;
    Date dateOfBirth;
    String objectId;
    String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Profile(){
        firstName = "alan";
        lastName = "turing";
        dateOfBirth = new Date();
        email = "levyf2001@gmail.com";
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }


}
