package com.kingdew.serv.Frags;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingdew.serv.Adapters.JobAdapter;
import com.kingdew.serv.AddJobActivity;
import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.R;

public class CHomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chome, container, false);
        RecyclerView rev=view.findViewById(R.id.chomeRec);
        rev.setLayoutManager(new LinearLayoutManager(getContext()));

        DBHelper helper=new DBHelper(getContext());
        JobAdapter adapter=new JobAdapter(getContext(),helper.getJobs());
        rev.setAdapter(adapter);

        return view;
    }
}