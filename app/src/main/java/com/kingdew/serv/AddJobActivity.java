package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;

import io.paperdb.Paper;

public class AddJobActivity extends AppCompatActivity {
    EditText jname,jaddress,jtele,jdesc;
    String[] items={"Room Cleaning","Kitchen Cleaning","Floor Cleaning","Bathroom Cleaning","Garden Cleaning"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    String item;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        Paper.init(this);

        //jname=findViewById(R.id.job_title);
        jaddress=findViewById(R.id.job_address);
        jtele=findViewById(R.id.job_tele);
        jdesc=findViewById(R.id.job_desc);


        autoCompleteTextView=findViewById(R.id.acTV);
        adapterItems=new ArrayAdapter<String>(this,R.layout.type_item,items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item=adapterView.getItemAtPosition(i).toString();

            }
        });

        findViewById(R.id.add_btn).setOnClickListener(view -> {
            String name,address,tele,desc;
            //name=jname.getText().toString();
            address=jaddress.getText().toString();
            tele=jtele.getText().toString();
            desc=jdesc.getText().toString();

            if (item.isEmpty() || address.isEmpty() || tele.isEmpty() || desc.isEmpty()){
                Toast.makeText(this, "Fill the all fields", Toast.LENGTH_SHORT).show();
            }else{
                DBHelper helper=new DBHelper(this);

                if (item.equals("Room Cleaning")){
                    price=5000;
                }else if (item.equals("Kitchen Cleaning")){
                    price=6000;
                }else if (item.equals("Floor Cleaning")){
                    price=4000;
                }else if (item.equals("Bathroom Cleaning")){
                    price=8000;
                }else if (item.equals("Garden Cleaning")){
                    price=10000;
                }


                if (helper.insertJob(item,price,"pending", Paper.book().read("email"),"-","-",desc,address,tele)){
                    Toast.makeText(this, "Job added", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Job not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}