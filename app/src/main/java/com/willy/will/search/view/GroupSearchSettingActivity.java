package com.willy.will.search.view;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.adapter.RecyclerViewSetter;
import com.willy.will.search.model.PopupActivity;

import java.util.ArrayList;

public class GroupSearchSettingActivity extends PopupActivity {

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
        ArrayList<String> list = new ArrayList();
        list.add("전체");
        list.add("첫 번째 그룹");
        list.add("두 번째 그룹");
        list.add("세 번째 그룹");
        list.add("네 번째 그룹");
        list.add("다섯 번째 그룹");
        // ~Set data of item

        // Set RecyclerView
        recyclerView = new RecyclerViewSetter(
                R.id.group_recycler_view, getWindow().getDecorView(),
                R.integer.text_recycler_item_type, list,
                R.string.selection_id_group_search_setting, true
        ).setRecyclerView();
        // ~Set RecyclerView
    }

}
