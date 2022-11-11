package com.kingdew.serv.Frags;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingdew.serv.AddJobActivity;
import com.kingdew.serv.R;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
            view.findViewById(R.id.addJob).setOnClickListener(view1 -> {
                startActivity(new Intent(getContext(), AddJobActivity.class));
            });

        return view;
    }
}