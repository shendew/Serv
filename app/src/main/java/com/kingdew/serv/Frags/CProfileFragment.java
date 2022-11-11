package com.kingdew.serv.Frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.Job;
import com.kingdew.serv.R;

import java.util.ArrayList;

import io.paperdb.Paper;


public class CProfileFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_cprofile, container, false);
        TextView type=v.findViewById(R.id.p_type);
        TextView name=v.findViewById(R.id.p_name);
        TextView avail=v.findViewById(R.id.p_ajb);
        TextView finished=v.findViewById(R.id.p_fjb);
        TextView ajobs=v.findViewById(R.id.p_myj);
        Paper.init(getContext());

        DBHelper helper=new DBHelper(getContext());
        User user=helper.getUsers(Paper.book().read("email"));

        ArrayList<Job> acceptedJObs=helper.getAceptedJobs(Paper.book().read("email"));
        ArrayList<Job> finishedJObs=helper.getFinishedJobs(Paper.book().read("email"));
        avail.setText(" "+acceptedJObs.size());
        finished.setText(" "+acceptedJObs.size());
        ajobs.setText(" "+(acceptedJObs.size()+acceptedJObs.size()));

        type.setText("("+user.getType()+")");
        name.setText(user.getName());

        return v;
    }
}