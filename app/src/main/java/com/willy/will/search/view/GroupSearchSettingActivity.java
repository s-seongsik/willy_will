package com.willy.will.search.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.adapter.RecyclerViewAdapter;
import com.willy.will.adapter.RecyclerViewSetter;
import com.willy.will.common.model.Group;
import com.willy.will.search.model.PopupActivity;

import java.util.ArrayList;

public class GroupSearchSettingActivity extends PopupActivity {

    private TextView selectingAllView = null;
    private RecyclerView recyclerView = null;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     */
    public GroupSearchSettingActivity() {
        super(R.layout.activity_group_search_setting);
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

        // Set data of item
        ArrayList<Group> list = new ArrayList<>();
        list.add(new Group(1, "첫 번째 그룹"));
        list.add(new Group(2, "두 번째 그룹"));
        list.add(new Group(3, "세 번째 그룹"));
        list.add(new Group(4, "네 번째 그룹"));
        list.add(new Group(5, "다섯 번째 그룹"));
        // ~Set data of item

        // Set selecting all TextView
        selectingAllView = findViewById(R.id.selecting_all);
        selectingAllView.setSelected(true);
        // ~Set selecting all TextView

        // Set RecyclerView
        recyclerView = new RecyclerViewSetter(
                R.id.group_search_setting_recycler_view, getWindow().getDecorView(),
                R.integer.group_search_setting_recycler_item_type, list,
                R.string.selection_id_group_search_setting, true
        ).setRecyclerView();
        // ~Set RecyclerView
    }

    public void onSelectAll(View view) {
        if(selectingAllView.isSelected()) {
            selectingAllView.setSelected(false);
        }
        else {
            selectingAllView.setSelected(true);
            ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().clearSelection();
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    protected boolean setResults(Intent intent) {
        return false;
    }

}
