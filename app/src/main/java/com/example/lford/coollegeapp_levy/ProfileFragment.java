package com.example.lford.coollegeapp_levy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle){
        super.onCreateView(inflater, view, bundle);

        //New code
        View rootView = inflater.inflate(R.layout.fragment_profile, view, false);
        return rootView;
    }
}
