package com.example.college_student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {


    public static List<StudentActivity> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNav = findViewById(R.id.main_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HomeFragment()).commit();

        studentsList = new ArrayList<>();
//
        studentsList.add(new StudentActivity(11, R.drawable.male, "Nick Bay", "Washington", "Male"));
        studentsList.add(new StudentActivity(12, R.drawable.female, "Nicky Mary", "New York", "Female"));
        studentsList.add(new StudentActivity(13, R.drawable.others, "Young Me", "Dallas", "Others"));
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()) {

                        case R.id.nav_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.nav_add_student:
                            selectFragment = new AddStudentFragment();
                            break;
                        case R.id.nav_about_us:
                            selectFragment = new AboutUsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectFragment).commit();
                    return true;

                }


            };
}


