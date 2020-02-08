package com.example.willy_will;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.SearchSettingRecyclerViewAdapter;

public class activitySearchSetting extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;

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
        setContentView(R.layout.activity_search_setting);

        // Set data of item
        ArrayList<String> list = new ArrayList<>();
        list.add("첫 번째 그룹");
        list.add("두 번째 그룹");
        list.add("세 번째 그룹");
        // ~Set data of item
        // Set RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.group_list_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new SearchSettingRecyclerViewAdapter(list);
        // ↓↓↓↓↓↓↓↓↓↓ ERROR ↓↓↓↓↓↓↓↓↓↓
        //recyclerView.setAdapter(recyclerViewAdapter);
        // ~Set RecyclerView
    }

    /**
     * https://ghj1001020.tistory.com/9
     */

    /**
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */

}
