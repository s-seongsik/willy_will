package com.example.willy_will;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class activitySearchSetting extends Activity {

    private RecyclerView groupListRecyclerView;
    private RecyclerView.Adapter groupListAdapter;
    private RecyclerView.LayoutManager groupListLayoutManager;

    /**
     * Last Modified: 2020-02-08
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
        setContentView(R.layout.activity_search_setting);

        // Set RecyclerView
        groupListRecyclerView = (RecyclerView) findViewById(R.id.group_list_view);
        groupListRecyclerView.setHasFixedSize(true);
        groupListLayoutManager = new LinearLayoutManager(this);
        groupListRecyclerView.setLayoutManager(groupListLayoutManager);
        String[] groupListDataset = {"첫 번째 그룹", "두 번째 그룹"};
        groupListAdapter = new GroupListAdapter(groupListDataset);
        groupListRecyclerView.setAdapter(groupListAdapter);
    }

    /**
     * https://ghj1001020.tistory.com/9
     */

    /**
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */

}
