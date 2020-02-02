package com.example.willy_will;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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

    public void btnSearchClick(){
        Intent intent = new Intent(activityBase.this , activityItemSearch.class);
        startActivity(intent);
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
