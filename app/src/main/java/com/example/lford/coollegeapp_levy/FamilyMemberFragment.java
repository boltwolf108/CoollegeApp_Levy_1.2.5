package com.example.lford.coollegeapp_levy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FamilyMemberFragment extends Fragment {
    @Override
    onCreativeView (LayoutInflater inflater, ViewGroup view, Bundle bundle){
        super.onCreateView(inflater, view, bundle);

        View rootView = inflater.inflate(R.layout.fragment_family_member, view, false);
        return view;
    }
}
