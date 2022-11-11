package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;

public class RegisterActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText Ename,Ephone,Eemail,Epass,Erpass,Etype;
    AppCompatButton register;
    String[] items={"Cleaner","House holder"};
    String item;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initId();
        autoCompleteTextView=findViewById(R.id.acTV);
        adapterItems=new ArrayAdapter<String>(this,R.layout.type_item,items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item=adapterView.getItemAtPosition(i).toString();

            }
        });

        register.setOnClickListener(view -> {
            String email,name,phone,pass;
            email=Eemail.getText().toString();
            name=Ename.getText().toString();
            phone=Ephone.getText().toString();
            pass=Epass.getText().toString();

            if (!pass.equals(Erpass.getText().toString())){
                Erpass.setError("Password miss match");
            }else{

                dbHelper=new DBHelper(this);
                if (!email.isEmpty() && !name.isEmpty() && !phone.isEmpty() && !pass.isEmpty()){
                    if (dbHelper.insertUserData(email,name,phone,pass,item)){
//                    if (dbHelper.insertUserData("c","c","c","c",item)){
                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Please fill the all fields", Toast.LENGTH_SHORT).show();
                }
            }






        });

        findViewById(R.id.reg_login).setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        });

    }

    private void initId() {
        Eemail=findViewById(R.id.reg_mail);
        Ename=findViewById(R.id.reg_name);
        Epass=findViewById(R.id.reg_pass);
        Erpass=findViewById(R.id.reg_rpass);
        Ephone=findViewById(R.id.reg_phone);

        register=findViewById(R.id.reg_btn);
    }
}