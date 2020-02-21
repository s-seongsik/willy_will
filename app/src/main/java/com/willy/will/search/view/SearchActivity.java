package com.willy.will.search.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.willy.will.R;
import com.willy.will.common.model.Group;
import com.willy.will.search.model.Distance;
import com.willy.will.search.model.DistanceSet;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private String selectedGroupsKey = null;
    private String selectedDoneKey = null;
    private String includedRepeatKey = null;
    private String selectedDistanceKey = null;

    private String extraNameCode = null;
    private Resources resources = null;
    private int code = 0;

    private ArrayList<Group> selectedGroups = null;
    private String selectedDone = null;
    private boolean includedRepeat;
    private Distance selectedDistance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        resources = getResources();
        extraNameCode = resources.getString(R.string.requestCode);

        initSearchSetting(getWindow().getDecorView());

        selectedGroupsKey = resources.getString(R.string.selectedGroups);
        selectedDoneKey = resources.getString(R.string.selectedDone);
        includedRepeatKey = resources.getString(R.string.includedRepeat);
        selectedDistanceKey = resources.getString(R.string.selectedDistance);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Back to BaseActivity (Main View)
     * Called when the user taps the back_button
     * Check focusing
     * @param view
     */
    public void backToMain(View view) {
        // Check focusing
        View focusedView = getCurrentFocus();
        if(focusedView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        // ~Check focusing
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
        intent.putParcelableArrayListExtra(selectedGroupsKey, selectedGroups);

        code = resources.getInteger(R.integer.group_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-15
     * Created By: Shin Minyong
     * Function: Bring up SearchSettingActivity (Done and Repeat Setting for Search)
     * Called when the user taps the done_repeat_search_setting_button
     * @param view
     */
    public void bringUpDoneRepeatSearchSetting(View view) {
        Intent intent = new Intent(this, DoneRepeatSearchSettingActivity.class);
        intent.putExtra(selectedDoneKey, selectedDone);
        intent.putExtra(includedRepeatKey, includedRepeat);

        code = resources.getInteger(R.integer.done_repeat_search_setting_code);
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
        intent.putExtra(selectedDistanceKey, selectedDistance);

        code = resources.getInteger(R.integer.distance_search_setting_code);
        intent.putExtra(extraNameCode, code);
        startActivityForResult(intent, code);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-21
     * Created By: Shin Minyong
     * Function: Initialize Search Setting
     * Called on Create and
     * called when the user taps the revert_search_setting_button
     * @param view
     */
    public void initSearchSetting(View view) {
        selectedGroups = new ArrayList<>();
        selectedDone = resources.getString(R.string.all);
        includedRepeat = true;
        selectedDistance = DistanceSet.distances.get(0);
    }

    /**
     * Last Modified: 2020-02-21
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

        Resources resources = getResources();

        // Success to receive data
        if(resultCode == Activity.RESULT_FIRST_USER) {
            // Group Search Setting
            if (requestCode == resources.getInteger(R.integer.group_search_setting_code)) {
                selectedGroups = data.getParcelableArrayListExtra(selectedGroupsKey);
            }
            // Done and Repeat Search Setting
            else if (requestCode == getResources().getInteger(R.integer.done_repeat_search_setting_code)) {
                selectedDone = data.getStringExtra(selectedDoneKey);
                includedRepeat = data.getBooleanExtra(includedRepeatKey, true);
            }
            // Period Search Setting
            else if (requestCode == getResources().getInteger(R.integer.period_search_setting_code)) {
                //
            }
            // Distance Search Setting
            else if (requestCode == getResources().getInteger(R.integer.distance_search_setting_code)) {
                selectedDistance = data.getParcelableExtra(selectedDistanceKey);
            }
        }
    }

}
