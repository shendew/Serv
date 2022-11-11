package com.kingdew.serv.Frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kingdew.serv.Adapters.JobAdapter;
import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.R;

import io.paperdb.Paper;


public class MyJobsFragment extends Fragment {



    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_jobs, container, false);
        Paper.init(getContext());

        recyclerView=view.findViewById(R.id.allJobsRView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DBHelper helper=new DBHelper(getContext());


//        JobAdapter adapter=new JobAdapter(getContext(),helper.getmyJobs(Paper.book().read("email")));
        JobAdapter adapter=new JobAdapter(getContext(),helper.getmyJobs(Paper.book().read("email")));
        recyclerView.setAdapter(adapter);
        return view ;


    }
}