package com.example.lford.coollegeapp_levy;

public class Guardian extends FamilyMember {
    String lastName;
    String firstName;
    String occupation;

    public Guardian(String lastName, String firstName, String occupation) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.occupation = occupation;
    }

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

    public Guardian() {
        super();
        occupation = "unknown";
    }

    public Guardian(String firstName, String lastName) {
        occupation = "unknown";
        //super(firstName, lastName);
    }

    public String toString() {
        String result = "Guardian: " + this.getFirstName() + this.getLastName() + "\nOccupation : " + this.occupation;
        return result;
    }

}