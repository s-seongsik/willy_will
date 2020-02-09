package adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.willy_will.R;

import java.util.ArrayList;

public class SearchSettingRecyclerViewAdapter extends RecyclerView.Adapter<SearchSettingRecyclerViewAdapter.TextViewHolder> {

    /**
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */

    /**
     * https://recipes4dev.tistory.com/154
     * https://recipes4dev.tistory.com/167
     */

    private ArrayList<String> dset;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-09
     * Created By: Shin Minyong
     * Function: Provide a reference to the views for each data item
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public class TextViewHolder extends RecyclerView.ViewHolder{
        public TextView txtV;
        public TextViewHolder(TextView textView) {
            super(textView);
            txtV = textView.findViewById(R.id.search_setting_recyclerview_text);
        }
    }

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-09
     * Created By: Shin Minyong
     * Function: Provide a suitable constructor (depends on the kind of dataset)
     * @param dataset
     */
    public SearchSettingRecyclerViewAdapter(ArrayList<String> dataset) {
        dset = dataset;
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
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // ↓↓↓↓↓↓↓↓↓↓ ERROR ↓↓↓↓↓↓↓↓↓↓
        TextView textView = (TextView) layoutInflater.inflate(R.layout.search_setting_recyclerview_item, parent, false);
        TextViewHolder textViewHolder = new TextViewHolder(textView);
        return textViewHolder;
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
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        String data = dset.get(position);
        holder.txtV.setText(data);
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
