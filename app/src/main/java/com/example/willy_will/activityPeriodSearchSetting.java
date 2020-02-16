package com.example.willy_will;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class activityPeriodSearchSetting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ~Remove title bar
        setContentView(R.layout.activity_period_search_setting);
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
