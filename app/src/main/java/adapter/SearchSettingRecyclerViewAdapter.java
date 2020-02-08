package adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.willy_will.R;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupListViewHolder> {

    /**
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */

    /**
     * https://recipes4dev.tistory.com/154
     * https://recipes4dev.tistory.com/167
     */

    private String[] dataset;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Provide a reference to the views for each data item
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class GroupListViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public GroupListViewHolder(TextView txtV) {
            super(txtV);
            textView = txtV;
        }
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-08
     * Created By: Shin Minyong
     * Function: Provide a suitable constructor (depends on the kind of dataset)
     * @param groupDataset
     */
    public GroupListAdapter(String[] groupDataset) {
        dataset = groupDataset;
    }

    /**
     * Last Modified: 2020-02-08
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Create new views (invoked by the layout manager)
     * @param parent
     * @param viewType
     * @return groupListViewHolder
     */
    @NonNull
    @Override
    public GroupListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TextView textView = (TextView) layoutInflater.inflate(R.layout.search_setting_recyclerview_item, parent, false);
        // ...
        GroupListViewHolder groupListViewHolder = new GroupListViewHolder(textView);
        return groupListViewHolder;
    }

    /**
     * Last Modified: 2020-02-08
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull GroupListViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(dataset[position]);
    }

    /**
     * Last Modified: 2020-02-08
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * Function: Return the size of the dataset (invoked by the layout manager)
     * @return dataset.length
     */
    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
