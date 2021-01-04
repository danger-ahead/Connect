package com.connect;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends Fragment {

    private FirebaseAuth firebaseAuth;


    public Profile() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        firebaseAuth = FirebaseAuth.getInstance();
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        Button logout = (Button) view.findViewById(R.id.logout2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        return view;
    }
    public void logout(){
        firebaseAuth.signOut();
        getActivity().onBackPressed();
    }
}