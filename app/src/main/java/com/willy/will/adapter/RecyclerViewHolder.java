package com.willy.will.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.main.model.mainListItem;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private int t;
    private Context cntxt;

    // Items
    private TextView textView;
    private TextView tv_rank;
    private TextView tv_name;
    private TextView tv_routine;
    private TextView tv_time;
    private CheckBox cb_done;
    // ~Items

    /**
     * Last Modified: 2020-02-12
     * Last Modified By: Shin Minyong
     * Created: 2020-02-11
     * Created By: Shin Minyong
     * Function: Initialization (including Item View)
     * @param type
     * @param view
     * @param context
     * @param <T>
     */
    public <T> RecyclerViewHolder(int type, View view, final Context context) {
        super(view);
        cntxt = context;
        t = type;

        // to-do item
        if(type == context.getResources().getInteger(R.integer.to_do_item_type)) {
            // toDoItem = view.findViewById(R.id....)
            tv_time = view.findViewById(R.id.tv_time);
            tv_rank = view.findViewById(R.id.tv_rank);
            tv_name = view.findViewById(R.id.tv_name);
            tv_routine = view.findViewById(R.id.tv_routine);
            cb_done = view.findViewById(R.id.cb_done);

        }
        // textview item
        else if(type == context.getResources().getInteger(R.integer.textview_type)) {
            textView = view.findViewById(R.id.recycleritem_text);
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
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-12
     * Created By: Shin Minyong
     * Function: Bind data to the item (com.willy.will.adapter)
     * @param type
     * @param data
     * @param isActivated
     * @param <T>
     */
    public <T> void bind(int type, T data, boolean isActivated) {
        // to-do item
        if(t == cntxt.getResources().getInteger(R.integer.to_do_item_type)) {
            mainListItem mitem = (mainListItem) data;
            tv_time.setText(mitem.getTime());
            tv_rank.setText(mitem.getRank());
            tv_name.setText(mitem.getName());
            tv_routine.setText(mitem.getRoutine());
            cb_done.setActivated(mitem.getDone());

            itemView.setActivated(isActivated);
        }
        // textview item
        else if(t == cntxt.getResources().getInteger(R.integer.textview_type)) {
            String text = (String) data;
            textView.setText(text);
            itemView.setActivated(isActivated);
        }
    }
}
