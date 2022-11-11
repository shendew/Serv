package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;

import io.paperdb.Paper;

public class AddJobActivity extends AppCompatActivity {
    EditText jname,jaddress,jtele,jdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        Paper.init(this);

        jname=findViewById(R.id.job_title);
        jaddress=findViewById(R.id.job_address);
        jtele=findViewById(R.id.job_tele);
        jdesc=findViewById(R.id.job_desc);

        findViewById(R.id.add_btn).setOnClickListener(view -> {
            String name,address,tele,desc;
            name=jname.getText().toString();
            address=jaddress.getText().toString();
            tele=jtele.getText().toString();
            desc=jdesc.getText().toString();

            if (name.isEmpty() || address.isEmpty() || tele.isEmpty() || desc.isEmpty()){
                Toast.makeText(this, "Fill the all fields", Toast.LENGTH_SHORT).show();
            }else{
                DBHelper helper=new DBHelper(this);
                if (helper.insertJob(name,10,"pending", Paper.book().read("email"),"-","-",desc,address,tele)){
                    Toast.makeText(this, "Job added", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Job not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}