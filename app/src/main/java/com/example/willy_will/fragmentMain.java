package com.example.willy_will;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import adapter.mainListAdapter;

public class fragmentMain extends Fragment {
    // dont fix it
    private final static String EXTRA_ADAPTER = "BaseAdpater";

    // example extra string
    private final static String EXTRA_INT = "someInt";
    private final static String EXTRA_STRING = "someTitle";

    // omission database object
    public static final fragmentMain newInstance(int page, String title, BaseAdapter adapter) {
        // example of communication
        fragmentMain fragment = new fragmentMain();
        Bundle args = new Bundle();
        args.putInt(EXTRA_INT, page);
        args.putString(EXTRA_STRING, title);

        //
        args.putSerializable(EXTRA_ADAPTER, (mainListAdapter)adapter);
        //

        fragment.setArguments(args);
        return fragment;
        // ~example
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView mainListView = ((ListView)view.findViewById(R.id.mainItemList));
        mainListView.setOnItemClickListener(mOnItemClickListner);

        refreshMainList(mainListView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    // setValue n Adapter
    private void refreshMainList(ListView mainListView){
        int num = getArguments().getInt(EXTRA_INT);
        String rank = getArguments().getString((EXTRA_STRING));
        String title = getArguments().getString(EXTRA_STRING);
        //String routine = R.string.routine_true;

        mainListAdapter mainListAdapter = (mainListAdapter) getArguments().getSerializable(EXTRA_ADAPTER);
        mainListAdapter.addItem(rank,title, "num is" + num);
        mainListView.setAdapter(mainListAdapter);
    }

    // list event listner
    private AdapterView.OnItemClickListener mOnItemClickListner = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /*
            remain thing
            1. get listView item info
            2. set info in acrivityDetail Intent
            3. display
             */
            Intent intent = new Intent(getContext(), activityDetail.class);
            startActivity(intent);
        }
    }; //~ listener
}
