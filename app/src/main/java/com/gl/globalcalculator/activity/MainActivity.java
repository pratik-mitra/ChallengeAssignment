package com.gl.globalcalculator.activity;

import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.gl.globalcalculator.R;
import com.gl.globalcalculator.adapter.CustomViewPagerAdapter;
import com.gl.globalcalculator.fragment.BasicCalculatorFragment;
import com.gl.globalcalculator.fragment.ScientificCalculatorFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private CustomViewPagerAdapter adapter;
    private TabLayout tabLayout;

    private ImageButton redRoundButton;
    private ImageButton greenRoundButton;
    private ImageButton blueRoundButton;

    private RelativeLayout basicRelativeLayout;
    private RelativeLayout scientificRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.id_view_pager);
        adapter = new CustomViewPagerAdapter(getSupportFragmentManager(),getAllFragment());
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.id_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        redRoundButton = navigationView.findViewById(R.id.rou_btn_1);
        greenRoundButton = navigationView.findViewById(R.id.rou_btn_2);
        blueRoundButton = navigationView.findViewById(R.id.rou_btn_3);

        redRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicRelativeLayout =(RelativeLayout) findViewById(R.id.id_basic_layout);
                scientificRelativeLayout =(RelativeLayout) findViewById(R.id.id_scientific_layout);
                basicRelativeLayout.setBackgroundColor(Color.RED);
                scientificRelativeLayout.setBackgroundColor(Color.RED);
            }
        });

        greenRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicRelativeLayout =(RelativeLayout) findViewById(R.id.id_basic_layout);
                scientificRelativeLayout =(RelativeLayout) findViewById(R.id.id_scientific_layout);
                basicRelativeLayout.setBackgroundColor(Color.GREEN);
                scientificRelativeLayout.setBackgroundColor(Color.GREEN);
            }
        });

        blueRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicRelativeLayout =(RelativeLayout) findViewById(R.id.id_basic_layout);
                scientificRelativeLayout =(RelativeLayout) findViewById(R.id.id_scientific_layout);
                basicRelativeLayout.setBackgroundColor(Color.BLUE);
                scientificRelativeLayout.setBackgroundColor(Color.BLUE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (id == R.id.id_basic_calculator) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.id_scientific_calculator) {

            viewPager.setCurrentItem(1);
        }

        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<Fragment> getAllFragment(){

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new BasicCalculatorFragment());
        fragments.add(new ScientificCalculatorFragment());

        return fragments;
    }
}
