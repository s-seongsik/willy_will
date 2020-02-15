package com.example.willy_will;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.RecyclerViewAdapter;
import adapter.mainListAdapter;
import adapter.mainListItem;

public class fragmentMain extends Fragment {
    // dont fix it
    private final static String EXTRA_ADAPTER = "BaseAdpater";

    // example extra string
    private final static String EXTRA_INT = "someInt";
    private final static String EXTRA_STRING = "someTitle";

    //Recycler View
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private RecyclerViewAdapter adapter = null;
    private SelectionTracker<Long> tracker = null; // 선택했는지?

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
        ArrayList<mainListItem> list = new ArrayList<>();
        list.add(new mainListItem());

        // Set RecyclerView
        recyclerView = view.findViewById(R.id.mainItemList);
        recyclerView.setHasFixedSize(true); //안정적...고정사이즈
        // set LayoutManager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        // set Adapter
        final int TYPE = getResources().getInteger(R.integer.to_do_item_type);
        adapter = new RecyclerViewAdapter(TYPE, list);//itemlist
        recyclerView.setAdapter(adapter);
        // set Tracker
        tracker = new SelectionTracker.Builder<>(
                "example",
                recyclerView,
                new StableIdKeyProvider(recyclerView),
                new RecyclerItemDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                // Select multiple items
                SelectionPredicates.<Long>createSelectSingleAnything()
        ).build(); // 하나만 선택
        adapter.setTracker(tracker);
        tracker.addObserver(new SelectionTracker.SelectionObserver() {
            /**
             * Last Modified: 2020-02-12
             * Last Modified By: Shin Minyong
             * Created: -
             * Created By: -
             * Function: Initialization (including Item View)
             * */

            @Override //선택에 변화가 있을 떄 사용함
            public void onSelectionChanged() {
                super.onSelectionChanged();
                Intent intent = new Intent(getContext(), activityDetail.class);
                startActivity(intent);
            }
        });
        // ~Set RecyclerView

        /*
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView mainListView = ((ListView)view.findViewById(R.id.mainItemList));
        mainListView.setOnItemClickListener(mOnItemClickListner);


        refreshMainList(mainListView);*/
        return recyclerView;

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
