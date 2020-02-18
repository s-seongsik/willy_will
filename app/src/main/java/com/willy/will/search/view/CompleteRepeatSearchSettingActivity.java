package com.willy.will.search.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.adapter.RecyclerViewAdapter;
import com.willy.will.adapter.RecyclerViewSetter;
import com.willy.will.common.controller.App;
import com.willy.will.search.model.PopupActivity;

import java.util.ArrayList;

public class CompleteRepeatSearchSettingActivity extends PopupActivity {

    private RecyclerView recyclerView = null;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-18
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     */
    public CompleteRepeatSearchSettingActivity() {
        super(R.layout.activity_complete_repeat_search_setting);
    }

    /**
     * Last Modified: 2020-02-19
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set data of item
        ArrayList<String> list = new ArrayList<>();
        Resources resources = App.getContext().getResources();
        list.add(resources.getString(R.string.all));
        list.add(resources.getString(R.string.incomplete));
        list.add(resources.getString(R.string.complete));
        // ~Set data of item

        // Set RecyclerView
        recyclerView = new RecyclerViewSetter(
                R.id.complete_search_setting_recycler_view, getWindow().getDecorView(),
                R.integer.complete_search_setting_recycler_item_type, list,
                R.string.selection_id_complete_search_setting, false
        ).setRecyclerView();
        // ~Set RecyclerView

        // Set selecting all TextView
        ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().select(0L);
        // ~Set selecting all TextView
    }

    @Override
    protected boolean setResults(Intent intent) {
        return false;
    }

}
