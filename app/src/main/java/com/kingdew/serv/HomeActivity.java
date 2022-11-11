package com.kingdew.serv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.kingdew.serv.Frags.AllJobsFragment;
import com.kingdew.serv.Frags.HomeFragment;
import com.kingdew.serv.Frags.MyJobsFragment;
import com.kingdew.serv.Frags.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navi_view;
    FrameLayout container;
    HomeFragment homeFragment;
    AllJobsFragment allJobsFragment;
    ProfileFragment profileFragment;
    MyJobsFragment myJobsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navi_view=findViewById(R.id.home_navi);
        container=findViewById(R.id.container);

        homeFragment=new HomeFragment();
        allJobsFragment=new AllJobsFragment();
        profileFragment=new ProfileFragment();
        myJobsFragment=new MyJobsFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


        navi_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();;
                switch (id){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
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