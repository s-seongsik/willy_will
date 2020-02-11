package com.example.willy_will;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.RecyclerItemDetailsLookup;
import adapter.RecyclerViewAdapter;

public class activitySearchSetting extends Activity {

    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private RecyclerViewAdapter adapter = null;
    private SelectionTracker<Long> tracker = null;

    /**
     * Last Modified: 2020-02-09
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
        setContentView(R.layout.activity_group_search_setting);

        // Set data of item
        ArrayList<String> list = new ArrayList<>();
        list.add("첫 번째 그룹");
        list.add("두 번째 그룹");
        list.add("세 번째 그룹");
        // ~Set data of item
        // Set RecyclerView
        recyclerView = findViewById(R.id.group_list_view);
        recyclerView.setHasFixedSize(true);
        // set LayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // set Adapter
        final int TYPE = getResources().getInteger(R.integer.textview_type);
        adapter = new RecyclerViewAdapter(TYPE, list);
        recyclerView.setAdapter(adapter);
        // set Tracker
        tracker = new SelectionTracker.Builder<>(
                "groupSearchSettingSelection",
                recyclerView,
                new StableIdKeyProvider(recyclerView),
                new RecyclerItemDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                // Select multiple items
                SelectionPredicates.<Long>createSelectAnything()
        ).build();
        adapter.setTracker(tracker);
        // ~Set RecyclerView
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
