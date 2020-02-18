package com.willy.will.search.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.willy.will.R;
import com.willy.will.search.model.PopupActivity;

public class PeriodSearchSettingActivity extends PopupActivity {

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     */
    public PeriodSearchSettingActivity() {
        super(R.layout.activity_period_search_setting);
    }

    /**
     * Last Modified: 2020-02-17
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // temp
        Button doneStartButton = findViewById(R.id.start_of_complete_button);
        Button doneEndButton = findViewById(R.id.end_of_complete_button);
        doneStartButton.setEnabled(false);
        doneEndButton.setEnabled(false);
        // ~temp
    }

    @Override
    protected boolean setResults(Intent intent) {
        return false;
    }

}
