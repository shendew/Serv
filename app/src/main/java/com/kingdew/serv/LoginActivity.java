package com.kingdew.serv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.kingdew.serv.DB.DBHelper;

import java.util.ArrayList;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText Eemail,Epass;
    AppCompatButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initId();
        dbHelper=new DBHelper(this);
        Paper.init(this);
        //dbHelper.insertUserDatat();

        login.setOnClickListener(view -> {
            //String email,pass;
            String email=Eemail.getText().toString();
            String pass=Epass.getText().toString();



            //startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            //startActivity(new Intent(LoginActivity.this,CleanerHomeActivity.class));


            if (!email.isEmpty() && !pass.isEmpty()){

                ArrayList<String> res=dbHelper.login(email,pass) ;
                //Toast.makeText(this, ""+res, Toast.LENGTH_SHORT).show();
                if (!res.isEmpty()){

                    if (!res.get(0).equals("emp") && res.get(0).equals("Cleaner") ){
                        Paper.book().write("email",res.get(2));
                        Paper.book().write("type",res.get(0));
                        startActivity(new Intent(LoginActivity.this,CleanerHomeActivity.class));
                    }else if (!res.get(0).equals("emp") && res.get(0).equals("House holder") ){
                        Paper.book().write("email",res.get(2));
                        Paper.book().write("type",res.get(0));
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(this, "please check data", Toast.LENGTH_SHORT).show();
                    }
                }
            }else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }


        });

        findViewById(R.id.login_reg).setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
    }

    private void initId() {
        Eemail=findViewById(R.id.login_username);
        Epass=findViewById(R.id.login_userpass);
        login=findViewById(R.id.login_btn);
    }


}