package com.example.lford.coollegeapp_levy;

public class Sibling extends FamilyMember {
    String firstName;
    String lastName;

    public Sibling(){
        super();
    }

    public String toString(){
        String result = "Sibling: " + this.getFirstName() + this.getLastName();
        return result;
    }
    public Sibling(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
