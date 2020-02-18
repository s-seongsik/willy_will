package com.willy.will.search.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.willy.will.R;

public class SearchActivity extends AppCompatActivity {

    private String extraNameCode = null;
    private Resources resources = null;
    private int code = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        resources = getResources();
        extraNameCode = resources.getString(R.string.requestCode);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Back to BaseActivity (Main View)
     * Called when the user taps the back_button
     * @param view
     */
    public void backToMain(View view) {
        this.finish();
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Bring up SearchSettingActivity (Group Setting for Search)
     * Called when the user taps the group_search_setting_button
     * @param view
     */
    public void bringUpGroupSearchSetting(View view) {
        Intent intent = new Intent(this, GroupSearchSettingActivity.class);
        code = resources.getInteger(R.integer.group_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-15
     * Created By: Shin Minyong
     * Function: Bring up SearchSettingActivity (Complete Or Repeat Setting for Search)
     * Called when the user taps the complete_repeat_search_setting_button
     * @param view
     */
    public void bringUpCompleteRepeatSearchSetting(View view) {
        Intent intent = new Intent(this, CompleteRepeatSearchSettingActivity.class);
        code = resources.getInteger(R.integer.complete_repeat_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-15
     * Created By: Shin Minyong
     * Function: Bring up SearchSettingActivity (Period Setting for Search)
     * Called when the user taps the period_search_setting_button
     * @param view
     */
    public void bringUpPeriodSearchSetting(View view) {
        Intent intent = new Intent(this, PeriodSearchSettingActivity.class);
        code = resources.getInteger(R.integer.period_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-15
     * Created By: Shin Minyong
     * Function: Bring up SearchSettingActivity (Distance Setting for Search)
     * Called when the user taps the distance_search_setting_button
     * @param view
     */
    public void bringUpDistanceSearchSetting(View view) {
        Intent intent = new Intent(this, DistanceSearchSettingActivity.class);
        code = resources.getInteger(R.integer.distance_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: 2020-02-19
     * Last Modified By: Shin Minyong
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Receive result data from SearchSettingActivity (Setting for Search)
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Success to receive data
        if(resultCode == Activity.RESULT_FIRST_USER) {
            // Group Search Setting
            if (requestCode == getResources().getInteger(R.integer.group_search_setting_code)) {
                //
            }
            // Complete Or Repeat Search Setting
            else if (requestCode == getResources().getInteger(R.integer.complete_repeat_search_setting_code)) {
                //
            }
            // Period Search Setting
            else if (requestCode == getResources().getInteger(R.integer.period_search_setting_code)) {
                //
            }
            // Distance Search Setting
            else if (requestCode == getResources().getInteger(R.integer.distance_search_setting_code)) {
                //
            }
        }
    }

}
