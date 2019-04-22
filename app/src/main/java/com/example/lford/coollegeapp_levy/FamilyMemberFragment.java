package com.example.lford.coollegeapp_levy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FamilyMemberFragment extends Fragment {
    private TextView firstnametext;
    private TextView lastnametext;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle){
        super.onCreateView(inflater, view, bundle);
        Guardian guardian = new Guardian();
        //New code
        View rootView = inflater.inflate(R.layout.fragment_guardian, view, false);
        firstnametext = rootView.findViewById(R.id.firstEdit);
        lastnametext = rootView.findViewById(R.id.lastEdit);
        lastnametext.setText(guardian.getLastName());
        firstnametext.setText(guardian.getFirstName());
        return rootView;
    }
}
