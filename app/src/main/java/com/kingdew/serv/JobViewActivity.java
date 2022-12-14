package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.Frags.User;

import io.paperdb.Paper;

public class JobViewActivity extends AppCompatActivity {
    //TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_view);
        //data=findViewById(R.id.data);
        Paper.init(this);



        //String id=getIntent().getExtras().getString("jobID");
        String jobID=Paper.book().read("jobID");

        //Toast.makeText(this, ""+jobID, Toast.LENGTH_SHORT).show();

        DBHelper helper=new DBHelper(this);
        Job job= helper.getaJob(Integer.parseInt(jobID));
        User user=helper.getUsers(job.getJobOwner());

        TextView jbname= findViewById(R.id.jbname);
        TextView jbcname= findViewById(R.id.jbcname);
        TextView jbctele= findViewById(R.id.jbctele);
        TextView jbdesc=findViewById(R.id.jbdesc);

        AppCompatButton aceptJ=findViewById(R.id.acpt_j);
        AppCompatButton mac_j=findViewById(R.id.mac_j);

        aceptJ.setOnClickListener(view -> {

            if (helper.updateJob(jobID, Paper.book().read("email"))){
                Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        mac_j.setOnClickListener(view -> {
            if (helper.updateFJob(jobID, Paper.book().read("email"))){
                Toast.makeText(this, "Mark As Finished", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        if (!Paper.book().read("type").equals("Cleaner")){
            aceptJ.setVisibility(View.GONE);
        }

        if (!job.jobCompleter.equals(Paper.book().read("email"))){
            mac_j.setVisibility(View.GONE);
        }



        jbname.setText(job.getJobName());
        jbctele.setText(job.getJobTele());
        jbdesc.setText(job.getJobDesc());
        jbcname.setText(user.getName());




        //DBHelper dbHelper=new DBHelper(this);
        //data.setText("");


    }
}