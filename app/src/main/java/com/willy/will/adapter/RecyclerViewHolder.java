package com.willy.will.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.main.model.mainListItem;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    // Common
    private int TO_DO_CODE = 0;
    private int TEXT_CODE = 0;
    private Resources resources = null;
    // ~Common

    // View of Item
    private TextView textOnlyView;

    private TextView tv_rank;
    private TextView tv_name;
    private TextView tv_routine;
    private TextView tv_time;
    private CheckBox cb_done;
    // ~View of Item

    /**
     * Last Modified: 2020-02-17
     * Last Modified By: Shin Minyong
     * Created: 2020-02-11
     * Created By: Shin Minyong
     * Function: Initialization (including Item View)
     * @param type
     * @param view
     * @param <T>
     */
    public <T> RecyclerViewHolder(int type, View view) {
        super(view);
        resources = view.getContext().getResources();

        // Set codes by type
        TO_DO_CODE = resources.getInteger(R.integer.to_do_recycler_item_type);
        TEXT_CODE = resources.getInteger(R.integer.text_recycler_item_type);

        // To-do
        if(type == TO_DO_CODE) {
            tv_time = view.findViewById(R.id.tv_time);
            tv_rank = view.findViewById(R.id.tv_rank);
            tv_name = view.findViewById(R.id.tv_name);
            tv_routine = view.findViewById(R.id.tv_routine);
            cb_done = view.findViewById(R.id.cb_done);

        }
        // Text-only
        else if(type == TEXT_CODE) {
            textOnlyView = view.findViewById(R.id.text_recycler_item);
        }
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-12
     * Created By: Shin Minyong
     * Function: Get Item Details (To build Tracker)
     * @return details
     */
    public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        ItemDetailsLookup.ItemDetails<Long> details = new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @Nullable
            @Override
            public Long getSelectionKey() {
                return getItemId();
            }
        };

        return details;
    }

    /**
     * Last Modified: 2020-02-17
     * Last Modified By: Shin Minyong
     * Created: 2020-02-12
     * Created By: Shin Minyong
     * Function: Bind data to the item (com.willy.will.adapter)
     * @param type
     * @param data
     * @param isSelected
     * @param <T>
     */
    public <T> void bind(int type, T data, boolean isSelected) {
        // To-do
        if(type == TO_DO_CODE) {
            mainListItem mitem = (mainListItem) data;
            tv_time.setText(mitem.getTime());
            tv_rank.setText(mitem.getRank());
            tv_name.setText(mitem.getName());
            tv_routine.setText(mitem.getRoutine());
            cb_done.setActivated(mitem.getDone());
        }
        // Text-only
        else if(type == TEXT_CODE) {
            String text = (String) data;
            textOnlyView.setText(text);
        }

        itemView.setSelected(isSelected);
    }
}
