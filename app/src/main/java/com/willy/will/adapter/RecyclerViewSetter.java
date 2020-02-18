package com.willy.will.adapter;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.common.model.Group;
import com.willy.will.detail.view.activityDetail;
import com.willy.will.search.model.Distance;

import java.util.ArrayList;

public class RecyclerViewSetter {

    // Common (also written in RecyclerViewHolder)
    private int TO_DO_CODE = 0;
    private int GROUP_CODE = 0;
    private int COMPLETE_CODE = 0;
    private int DISTANCE_CODE = 0;
    // ~Common (also written in RecyclerViewHolder)

    // For Setting RecyclerView
    private View parentView = null;
    private Resources resources = null;
    private ArrayList list = null;
    private SelectionTracker.SelectionPredicate predicate = null;
    private int tId = 0;
    private int recyclerId = 0;
    private int selectId = 0;

    private SelectionTracker tracker = null;
    // ~For Setting RecyclerView

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Initialization
     * @param recyclerViewId
     * @param view
     * @param typeId
     * @param dataSet
     * @param selectionId
     * @param multipleSelection
     */
    public RecyclerViewSetter(int recyclerViewId,
                              View view,
                              int typeId,
                              ArrayList dataSet,
                              int selectionId,
                              boolean multipleSelection) {
        recyclerId = recyclerViewId;
        parentView = view;
        tId = typeId;
        list = dataSet;
        selectId = selectionId;

        // Set selection predicate for tracker
        if(multipleSelection) {
            predicate = SelectionPredicates.<Long>createSelectAnything();
        }
        else {
            predicate = SelectionPredicates.createSelectSingleAnything();
        }
        // ~Set selection predicate for tracker

        // Set resources
        resources = parentView.getResources();
        // Set codes by type (also written in RecyclerViewHolder:RecyclerViewHolder)
        TO_DO_CODE = resources.getInteger(R.integer.to_do_recycler_item_type);
        GROUP_CODE = resources.getInteger(R.integer.group_search_setting_recycler_item_type);
        COMPLETE_CODE = resources.getInteger(R.integer.complete_search_setting_recycler_item_type);
        DISTANCE_CODE = resources.getInteger(R.integer.distance_search_setting_recycler_item_type);
        // ~Set codes by type (also written in RecyclerViewHolder:RecyclerViewHolder)
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Set RecyclerView
     * Set RecyclerView, LayoutManager, Adapter, and Tracker
     * @return recyclerView
     */
    public RecyclerView setRecyclerView() {
        RecyclerView recyclerView = parentView.findViewById(recyclerId);
        recyclerView.setHasFixedSize(true);

        // set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(parentView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Set the type
        final int TYPE = resources.getInteger(tId);
        // set Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(TYPE, list, this);
        recyclerView.setAdapter(adapter);

        // set Tracker
        tracker = new SelectionTracker.Builder(
                resources.getString(selectId),
                recyclerView,
                new StableIdKeyProvider(recyclerView),
                new RecyclerItemDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                predicate
        ).build();
        adapter.setTracker(tracker);
        tracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onSelectionChanged() {
                super.onSelectionChanged();

                // To-do
                if(TYPE == TO_DO_CODE) {
                    changeToDoItem();
                }
                // Group
                else if(TYPE == GROUP_CODE) {
                    changeGroupItem();
                }
                // Complete
                else if(TYPE == COMPLETE_CODE) {
                    changeCompleteItem();
                }
                // Distance
                else if(TYPE == DISTANCE_CODE) {
                    changeDistanceItem();
                }
                // ERROR: Wrong type
                else {
                    Log.e("RecyclerViewSetter", "Setting: Wrong type");
                }
            }
        });

        return recyclerView;
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Change To-do Item
     * Change To-do Item of Main View or Search View on selection changed
     */
    private void changeToDoItem() {
        Intent intent = new Intent(parentView.getContext(), activityDetail.class);
        parentView.getContext().startActivity(intent);
    }

    /**
     * Last Modified: 2020-02-19
     * Last Modified By: Shin Minyong
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Change Group Item
     * Change Group Item of Group Search Setting View on selection changed
     */
    private void changeGroupItem() {
        if(tracker.hasSelection()) {
            TextView selectingAllView = parentView.findViewById(R.id.selecting_all);
            if(selectingAllView.isSelected()) {
                selectingAllView.setSelected(false);
            }
        }
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-19
     * Created By: Shin Minyong
     * Function: Change Complete Item
     * Change Complete Item of Complete Or Repeat Search Setting View on selection changed
     */
    private void changeCompleteItem() {
        //
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-19
     * Created By: Shin Minyong
     * Function: Change Distance Item
     * Change Distance Item of Distance Search Setting View on selection changed
     */
    private void changeDistanceItem() {
        //
    }

    /**
     * Last Modified: 2020-02-19
     * Last Modified By: Shin Minyong
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Get Layout ID for onCreateViewHolder of RecyclerViewAdapter
     * Layout ID is layout filename without extension(.xml)
     * @param type
     * @return
     */
    public int getLayoutId(int type) {
        int id = 0;

        // To-do
        if(type == TO_DO_CODE) {
            id = R.layout.listitem;
        }
        // Text-only (Group, Complete, Distance)
        else if(type == GROUP_CODE || type == COMPLETE_CODE || type == DISTANCE_CODE) {
            id = R.layout.recycleritem_text_only;
        }
        // ERROR: Wrong type
        else {
            Log.e("RecyclerViewHolder", "initializing: Wrong type");
        }

        return id;
    }

}
