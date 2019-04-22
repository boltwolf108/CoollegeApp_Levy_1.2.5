package com.example.lford.coollegeapp_levy;

public abstract class FamilyMember {

    public static final String EXTRA_RELATION = "org.pltw.examples.collegeapp.relation";
    public static final String EXTRA_INDEX = "org.pltw.examples.collegeapp.index";

    String mFirstName;
    String lastName;

    //------------------------------------------------------------------------------------------

    public String getFirstName() {
        return mFirstName;
    }
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    //-----------------------------------------------------------------------------------------

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //------------------------------------------------------------------------------------------

    public void testMethod(){
        if (mFirstName == "test"){
            mFirstName = "hello world";
        }
    }

    public FamilyMember(){
        mFirstName = "Family";
        lastName = "Member";
    }

    public FamilyMember(String firstName, String lastName){
        mFirstName = firstName;
        this.lastName = lastName;
    }

    public boolean equals(Object o) {
        if ((o instanceof Guardian) && (this instanceof Guardian)) {
            // both are guardians so cast the Object
            Guardian g = (Guardian) o;
            // test for equality of first and last names for g and this
            if(g.getFirstName() == mFirstName && g.getLastName() == lastName) {
                return true;
            }
            return false;
        }
        else{
            Sibling g = (Sibling) o;
            if(g.getFirstName() == mFirstName && g.getLastName() == lastName) {
                return true;
            }
            return false;
        }
    }
}
