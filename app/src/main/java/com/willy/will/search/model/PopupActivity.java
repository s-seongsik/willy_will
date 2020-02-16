package com.willy.will.search.model;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class PopupActivity extends Activity {

    private int layId = 0;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     * @param layoutId
     */
    public PopupActivity(int layoutId) {
        super();
        layId = layoutId;
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
        // Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ~Remove title bar
        setContentView(layId);
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-10
     * Created By: Shin Minyong
     * Function: Cancel search setting
     */
    public void cancelSetting(View view) {
        this.finish();
    }

    /**
     * https://ghj1001020.tistory.com/9
     */

    /**
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */

}
