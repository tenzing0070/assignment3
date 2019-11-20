package com.example.college_student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private AddStudentFragment addStudentFragment;
    private AboutUsFragment aboutUsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        homeFragment = new HomeFragment();
        addStudentFragment = new AddStudentFragment();
        aboutUsFragment = new AboutUsFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_add_student:
                            mMainNav.setItemBackgroundResource(R.color.colorAccent);
                           setFragment(addStudentFragment);
                            return true;


                    case R.id.nav_adbout_us:
                        mMainNav.setItemBackgroundResource(R.color.colorDarkGreen);
                        setFragment(aboutUsFragment);
                        return true;

                        default:
                            return false;
                        }

                    }




        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();



    }
}



