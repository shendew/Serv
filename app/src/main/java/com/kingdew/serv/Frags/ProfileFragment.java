package com.kingdew.serv.Frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.Job;
import com.kingdew.serv.R;

import java.util.ArrayList;

import io.paperdb.Paper;


public class ProfileFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);

        TextView type=v.findViewById(R.id.p_type);
        TextView name=v.findViewById(R.id.p_name);
        TextView avail=v.findViewById(R.id.p_ajb);
        TextView finished=v.findViewById(R.id.p_fjb);
        TextView ajobs=v.findViewById(R.id.p_myj);
        Paper.init(getContext());

        DBHelper helper=new DBHelper(getContext());
        User user=helper.getUsers(Paper.book().read("email"));

        ArrayList<Job> myJobs=helper.getmyJobs(Paper.book().read("email"));
        ArrayList<Job> finishedJObs=helper.getFinishedmyJobs(Paper.book().read("email"));
        ArrayList<Job> ava=helper.getavimyJobs(Paper.book().read("email"));
        avail.setText(" "+ava.size());
        finished.setText(" "+finishedJObs.size());
        ajobs.setText(" "+myJobs.size());

        type.setText("("+user.getType()+")");
        name.setText(user.getName());

        return v;
    }
}