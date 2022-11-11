package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;
import com.kingdew.serv.Frags.User;

public class JobViewActivity extends AppCompatActivity {
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_view);
        data=findViewById(R.id.data);

        DBHelper dbHelper=new DBHelper(this);
        data.setText("");


    }
}