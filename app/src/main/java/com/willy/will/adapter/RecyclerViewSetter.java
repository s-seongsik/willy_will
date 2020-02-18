package com.willy.will.adapter;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.detail.view.activityDetail;

import java.util.ArrayList;

public class RecyclerViewSetter {

    // Common
    private int TO_DO_CODE = 0;
    private int TEXT_CODE = 0;
    // ~Common

    // For Setting RecyclerView
    private View parentView = null;
    private Resources resources = null;
    private ArrayList list = null;
    private SelectionTracker.SelectionPredicate predicate = null;
    private int recyclerId = 0;
    private int tId = 0;
    private int selectId = 0;
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

        // Set resources
        resources = parentView.getResources();
        // Set codes by type
        TO_DO_CODE = resources.getInteger(R.integer.to_do_recycler_item_type);
        TEXT_CODE = resources.getInteger(R.integer.text_recycler_item_type);
    }

    /**
     * Last Modified: - 2020-02-18
     * Last Modified By: - Lee Jaeeun
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

        // set Adapter
        final int TYPE = resources.getInteger(tId);
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(TYPE, list, this);
        recyclerView.setAdapter(adapter);

        // set Tracker
        SelectionTracker tracker = new SelectionTracker.Builder(
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
                // Text-only
                else if(TYPE == TEXT_CODE) {
                    changeTextItem();
                }
            }

        });

        //swipe for delete
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT /*| ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP*/) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(parentView.getContext(), "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(parentView.getContext(), "on Swiped ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                list.remove(position);
                adapter.notifyDataSetChanged();

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        //~swipe for delete



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
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Shin Minyong
     * Function: Change Text Item
     * Change Text Item of Group Search Setting View on selection changed
     */
    private void changeTextItem() {
        Toast.makeText(parentView.getContext(), "아이템 누름!!!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Last Modified: -
     * Last Modified By: -
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
        // Text-only
        else if(type == TEXT_CODE) {
            id = R.layout.recycleritem_text_only;
        }

        return id;
    }

}
