package com.willy.will.search.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.adapter.RecyclerViewAdapter;
import com.willy.will.adapter.RecyclerViewSetter;
import com.willy.will.search.model.Distance;
import com.willy.will.search.model.DistanceSet;
import com.willy.will.search.model.PopupActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class DistanceSearchSettingActivity extends PopupActivity {

    private RecyclerView recyclerView = null;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-18
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     */
    public DistanceSearchSettingActivity() {
        super(R.layout.activity_distance_search_setting);
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
        ArrayList<Distance> list = new ArrayList<>();
        Iterator<Distance> iterator = DistanceSet.distances.iterator();
        Distance distance = null;
        while(iterator.hasNext()) {
            distance = iterator.next();
            if(distance.isUse()) {
                list.add(distance);
            }
        }
        // ~Set data of item

        // Set RecyclerView
        recyclerView = new RecyclerViewSetter(
                R.id.distance_search_setting_recycler_view, getWindow().getDecorView(),
                R.integer.distance_search_setting_recycler_item_type, list,
                R.string.selection_id_distance_search_setting, false
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
