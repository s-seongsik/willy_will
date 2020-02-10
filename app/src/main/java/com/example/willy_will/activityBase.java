package com.example.willy_will;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import adapter.viewPagerAdapter;

public class activityBase extends AppCompatActivity{

    private Spinner sp_group;
    ArrayList<String> spgroupList;
    ArrayAdapter<String> spgroupAdapter;

    fragmentCalander fragmentcalander;
    fragmentMain fragmentmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        fragmentcalander = new fragmentCalander();
        fragmentmain = new fragmentMain();


        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */

        //setDate
        TextView tv_date = (TextView) findViewById(R.id.tv_date);
        Date todaydate = Calendar.getInstance().getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
        String dateString = sdf.format(todaydate);
        tv_date.setText(dateString);

        //~setDate

        //set sp_group (fix later)
        spgroupList = new ArrayList<>();
        spgroupList.add("그룹1");
        spgroupList.add("그룹2");
        spgroupList.add("그룹3");
        spgroupList.add("그룹4");

        spgroupAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                spgroupList);

        sp_group = (Spinner)findViewById(R.id.sp_group);
        sp_group.setAdapter(spgroupAdapter);
        sp_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int i, long id) {
                Toast.makeText(getApplicationContext(),"선택된 아이템 : "+sp_group.getItemAtPosition(i),Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //~Set sp_group


        // set fab event Listener
        FloatingActionButton fab = findViewById(R.id.fabItemAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show Item add Activity
                Intent intent = new Intent(activityBase.this , activityItemAdd.class);
                startActivity(intent);
            }
        });
        // ~set fab event Listener

        // viewPagerbtnSearchClick
        ViewPager viewPager = findViewById(R.id.calanderViewPager);
        viewPager.setAdapter(new viewPagerAdapter(getSupportFragmentManager()));
        // ~ viewPager
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    public void btnSearchClick(View view){
        Intent intent = new Intent(activityBase.this , activityItemSearch.class);
        startActivity(intent);
    }


    public void btnCalendarClick(View view) {
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.calanderViewPager,fragmentcalander);
        fragment.commit();
    }


    /*
    @Override
    // tool bar
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //
        if (id == R.id.itemSearch){
            // show search activity
            Intent intent = new Intent(activityBase.this , activityItemSearch.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
