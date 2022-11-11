package com.kingdew.serv.Frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kingdew.serv.Adapters.JobAdapter;
import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.R;

import io.paperdb.Paper;


public class CMyJobsFragment extends Fragment {



    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_cmy_jobs, container, false);
        Paper.init(getContext());
        recyclerView=view.findViewById(R.id.allJobsRView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DBHelper helper=new DBHelper(getContext());


        JobAdapter adapter=new JobAdapter(getContext(),helper.getAceptedJobs(Paper.book().read("email")));
        recyclerView.setAdapter(adapter);
        return view;
    }
}