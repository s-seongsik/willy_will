package adapter;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemDetailsLookup extends ItemDetailsLookup<Long> {

    private RecyclerView rcyclrV = null;

    public RecyclerItemDetailsLookup(RecyclerView recyclerView) {
        rcyclrV = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
        View view = rcyclrV.findChildViewUnder(e.getX(), e.getY());
        if(view != null) {
            RecyclerViewHolder holder = (RecyclerViewHolder) rcyclrV.getChildViewHolder(view);
            return holder.getItemDetails();
        }
        return null;
    }
}
