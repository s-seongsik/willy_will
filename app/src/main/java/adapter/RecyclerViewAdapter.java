package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import com.example.willy_will.R;

import java.util.ArrayList;

public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<T> dset = null;
    private int type = 0;

    private SelectionTracker<Long> trckr = null;

    private Context context = null;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-09
     * Created By: Shin Minyong
     * Function: Provide a suitable constructor (depends on the kind of dataset)
     * @param dataset
     */
    public RecyclerViewAdapter(int code, ArrayList<T> dataset) {
        type = code;
        dset = dataset;

        setHasStableIds(true);
    }

    public void setTracker(SelectionTracker tracker) {
        trckr = tracker;
    }

    /**
     * Last Modified: 2020-02-09
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Create new views (invoked by the layout manager)
     * @param parent
     * @param viewType
     * @return textViewHolder
     */
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycleritem_textview, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(type, view, context);
        return holder;
    }

    /**
     * Last Modified: 2020-02-09
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        T data = dset.get(position);
        if(trckr != null) {
            holder.bind(type, data, trckr.isSelected(new Long(position)));
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    /**
     * Last Modified: 2020-02-09
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Return the size of the dataset (invoked by the layout manager)
     * @return dataset.size()
     */
    @Override
    public int getItemCount() {
        return dset.size();
    }

}
