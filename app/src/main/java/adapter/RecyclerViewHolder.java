package adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.willy_will.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private int t;
    private Context cntxt;

    // Items
    private TextView textView;
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
     * Function: Bind data to the item
     * @param type
     * @param data
     * @param isActivated
     * @param <T>
     */
    public <T> void bind(int type, T data, boolean isActivated) {
        // to-do item
        if(t == cntxt.getResources().getInteger(R.integer.to_do_item_type)) {
            // ...
        }
        // textview item
        else if(t == cntxt.getResources().getInteger(R.integer.textview_type)) {
            String text = (String) data;
            textView.setText(text);
            itemView.setActivated(isActivated);
        }
    }
}
