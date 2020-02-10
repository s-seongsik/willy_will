package com.example.willy_will;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activityItemSearch extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemsearch);
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
        Intent intent = new Intent(this, activitySearchSetting.class);
        startActivityForResult(intent, getResources().getInteger(R.integer.group_search_setting_code));
    }

    /**
     * Last Modified: -
     * Last Modified By: -
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

        if(requestCode == getResources().getInteger(R.integer.group_search_setting_code)) {
            if(resultCode == Activity.RESULT_OK) {
                // Success to receive data
            }
        }
    }

}
