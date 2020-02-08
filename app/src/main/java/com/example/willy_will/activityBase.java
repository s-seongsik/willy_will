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
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import adapter.viewPagerAdapter;

public class activityBase extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

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

        // viewPager
        ViewPager viewPager = findViewById(R.id.calanderViewPager);
        viewPager.setAdapter(new viewPagerAdapter(getSupportFragmentManager()));
        // ~ viewPager
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void btnSearchClick(View view){
        Intent intent = new Intent(activityBase.this , activityItemSearch.class);
        startActivity(intent);
    }

    public void btnCalendarClick(View view) {
        Fragment fragment = new fragmentCalander();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.calanderViewPager,fragment);
        fragmentTransaction.commit();
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
