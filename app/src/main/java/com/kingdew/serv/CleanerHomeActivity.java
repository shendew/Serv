package com.kingdew.serv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.kingdew.serv.Frags.AllJobsFragment;
import com.kingdew.serv.Frags.CHomeFragment;
import com.kingdew.serv.Frags.CMyJobsFragment;
import com.kingdew.serv.Frags.CProfileFragment;
import com.kingdew.serv.Frags.HomeFragment;
import com.kingdew.serv.Frags.MyJobsFragment;
import com.kingdew.serv.Frags.ProfileFragment;

public class CleanerHomeActivity extends AppCompatActivity {

    BottomNavigationView navi_view;
    FrameLayout container;
    CHomeFragment homeFragment;
    AllJobsFragment allJobsFragment;
    CProfileFragment profileFragment;
    CMyJobsFragment myJobsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_home);


        navi_view=findViewById(R.id.home_navi);
        container=findViewById(R.id.container);

        homeFragment =new CHomeFragment();
        profileFragment=new CProfileFragment();
        myJobsFragment=new CMyJobsFragment();
        allJobsFragment=new AllJobsFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


        navi_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();;
                switch (id){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.jobs:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,allJobsFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                    case R.id.mjobs:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,myJobsFragment).commit();
                        return true;
                }
                return false;
            }
        });


    }
}