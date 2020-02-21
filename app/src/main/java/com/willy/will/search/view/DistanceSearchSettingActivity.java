package com.willy.will.search.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

    private String selectedDistanceKey = null;

    private ArrayList<Distance> distanceList = null;
    private Distance selectedDistance;

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

        // Set a selected item
        selectedDistanceKey = getResources().getString(R.string.selectedDistance);

        selectedDistance = getIntent().getParcelableExtra(selectedDistanceKey);
        long selectedPosition = -1L;
        // ~Set a selected item

        // Set data of item
        distanceList = new ArrayList<>();
        Iterator<Distance> distancesIter = DistanceSet.distances.iterator();
        Distance distance = null;
        while(distancesIter.hasNext()) {
            distance = distancesIter.next();
            if(distance.isUse()) {
                distanceList.add(distance);
                // Set a selected item
                if(distance.getText().equals(selectedDistance.getText())) {
                    selectedPosition = Long.valueOf(distanceList.size() - 1);
                }
                // ~Set a selected item
            }
        }
        // ~Set data of item

        // Set RecyclerView
        recyclerView = new RecyclerViewSetter(
                R.id.distance_search_setting_recycler_view, getWindow().getDecorView(),
                R.integer.distance_search_setting_recycler_item_type, distanceList,
                R.string.selection_id_distance_search_setting, false
        ).setRecyclerView();
        // ~Set RecyclerView

        // Set a selected item
        ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().select(selectedPosition);
        // ~Set a selected item
    }

    /**
     * Last Modified: 2020-02-21
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * @param intent
     * @return success
     */
    @Override
    protected boolean setResults(Intent intent) {
        boolean success = true;
        try {
            Iterator selectIter = ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().getSelection().iterator();
            int selectedPosition = Math.toIntExact((Long) selectIter.next());
            selectedDistance = distanceList.get(selectedPosition);
        }
        catch (Exception e) {
            success = false;
            Log.e("GroupSearchSettingActivity", "Results: "+e.getMessage());
            e.printStackTrace();
        }
        finally {
            intent.putExtra(selectedDistanceKey, selectedDistance);
            return success;
        }
    }

}
