package com.willy.will.search.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.willy.will.R;

public class RadiusSearchSettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ~Remove title bar
        setContentView(R.layout.activity_radius_search_setting);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-15
     * Created By: Shin Minyong
     * Function: Cancel search setting
     */
    public void cancelSetting(View view) {
        this.finish();
    }

}
