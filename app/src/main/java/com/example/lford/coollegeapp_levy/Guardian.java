package com.example.lford.coollegeapp_levy;

public class Guardian extends FamilyMember {
    String lastName;
    String firstName;

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

    public Guardian(){
        super();
    }

    public Guardian(String firstName, String lastName){
        //super(firstName, lastName);
    }
}
