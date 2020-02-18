package com.willy.will.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.ItemTouchHelper;
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

    private TextView tvRank;
    private TextView tvName;
    private TextView tvRoutine;
    private TextView tvTime;
    private CheckBox cbDone;
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
            tvTime = view.findViewById(R.id.tv_time);
            tvRank = view.findViewById(R.id.tv_rank);
            tvName = view.findViewById(R.id.tv_name);
            tvRoutine = view.findViewById(R.id.tv_routine);
            cbDone = view.findViewById(R.id.cb_done);

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
            tvTime.setText(mitem.getTime());
            tvRank.setText(mitem.getRank());
            tvName.setText(mitem.getName());
            tvRoutine.setText(mitem.getRoutine());
            cbDone.setActivated(mitem.getDone());
        }
        // Text-only
        else if(type == TEXT_CODE) {
            String text = (String) data;
            textOnlyView.setText(text);
        }

        itemView.setSelected(isSelected);
    }


}
