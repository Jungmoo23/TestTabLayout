package com.example.testtab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    BlankFragment fragment;
    BlankFragment2 fragment2;
    Toolbar toolbar;

    FrameLayout frameLayout;
    Fragment fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
          try {
              setSupportActionBar(toolbar);

          }catch (Exception e){
              e.printStackTrace();
          }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


    TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);
    tabLayout.addTab(tabLayout.newTab().setText("테스트1"));
    tabLayout.addTab(tabLayout.newTab().setText("테스트2"));
    tabLayout.setOnTabSelectedListener(this);

        fragment = new BlankFragment();
        fragment2 = new BlankFragment2();
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();

                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();

                break;
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}