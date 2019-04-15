package com.example.lford.coollegeapp_levy;

import java.util.ArrayList;

public class Family {
    private final String TAG = Family.class.getName();

    ArrayList<FamilyMember> family = new ArrayList<>();

    private static Family sFamily;
    //------------------------------------------------------------------------------------------
    private Family() {
        family= new ArrayList<>();
        Guardian mom = new Guardian("my", "mother");
        Guardian dad = new Guardian("my", "father");
        Sibling dummy = new Sibling("my", "stupid bro");
        family.add(mom);
        family.add(dad);
        family.add(dummy);
    }
    //--------------------------------------------------------------------------------------
    public static Family getFamily(){
        if (sFamily == null){
            sFamily = new Family();
        }
        return sFamily;
    }
    //----------------------------------------------------------------------------------------
    public ArrayList<FamilyMember> getFamilyList(){
        return family;
    }

    public void setFamily(ArrayList<FamilyMember> family) {
        this.family = family;
    }
}
