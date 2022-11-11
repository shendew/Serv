package com.kingdew.serv.Frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingdew.serv.Adapters.JobAdapter;
import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.Job;
import com.kingdew.serv.R;

import java.util.ArrayList;


public class AllJobsFragment extends Fragment {


    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all_jobs, container, false);

        recyclerView=view.findViewById(R.id.aallJobsRView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));





        DBHelper helper=new DBHelper(getContext());

        ArrayList<Job> jobs=helper.getJobs();

        JobAdapter adapter=new JobAdapter(getContext(),jobs);
        recyclerView.setAdapter(adapter);



        return view;
    }
}