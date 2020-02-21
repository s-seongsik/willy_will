package com.willy.will.search.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.willy.will.R;
import com.willy.will.adapter.RecyclerViewAdapter;
import com.willy.will.adapter.RecyclerViewSetter;
import com.willy.will.search.model.PopupActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class DoneRepeatSearchSettingActivity extends PopupActivity {

    private String allStr = null;
    private String undoneStr = null;
    private String doneStr = null;

    private String selectedDoneKey = null;
    private String includedRepeatKey = null;

    private RecyclerView recyclerView = null;
    private CheckBox checkBox = null;

    /**
     * Last Modified: -
     * Last Modified By: -
     * Created: 2020-02-18
     * Created By: Shin Minyong
     * Function: Initialization (including layout ID)
     */
    public DoneRepeatSearchSettingActivity() {
        super(R.layout.activity_done_repeat_search_setting);
    }

    /**
     * Last Modified: 2020-02-21
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set data of item
        Resources resources = getResources();
        allStr = resources.getString(R.string.all);
        undoneStr = resources.getString(R.string.undone);
        doneStr = resources.getString(R.string.done);

        ArrayList<String> list = new ArrayList<>();
        list.add(allStr);
        list.add(undoneStr);
        list.add(doneStr);
        // ~Set data of item

        // Set Views
        recyclerView = new RecyclerViewSetter(
                R.id.done_search_setting_recycler_view, getWindow().getDecorView(),
                R.integer.done_search_setting_recycler_item_type, list,
                R.string.selection_id_done_search_setting, false
        ).setRecyclerView();

        checkBox = findViewById(R.id.including_repeat_check_box);
        // ~Set Views

        // Set a selected item and the check box
        selectedDoneKey = resources.getString(R.string.selectedDone);
        includedRepeatKey = resources.getString(R.string.includedRepeat);

        String selectedDone = getIntent().getStringExtra(selectedDoneKey);
        long position = -1L;
        if(selectedDone.equals(allStr)) {
            position = 0L;
        }
        else if(selectedDone.equals(undoneStr)) {
            position = 1L;
        }
        else if(selectedDone.equals(doneStr)) {
            position = 2L;
        }
        ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().select(position);

        boolean includedRepeat = getIntent().getBooleanExtra(includedRepeatKey, true);
        checkBox.setChecked(includedRepeat);
        // ~Set a selected item and the check box
    }

    /**
     * Last Modified: 2020-02-21
     * Last Modified By: Shin Minyong
     * Created: -
     * Created By: -
     * @param intent
     * @return success
     */
    @Override
    protected boolean setResults(Intent intent) {
        boolean success = true;
        String selectedDone = null;
        try {
            Iterator selectIter = ((RecyclerViewAdapter) recyclerView.getAdapter()).getTracker().getSelection().iterator();
            int selectedPosition = Math.toIntExact((Long) selectIter.next());
            switch (selectedPosition) {
                case 0: // all
                    selectedDone = getResources().getString(R.string.all);
                    break;
                case 1: // undone
                    selectedDone = getResources().getString(R.string.undone);
                    break;
                case 2: // done
                    selectedDone = getResources().getString(R.string.done);
                    break;
                default: // ERROR
                    throw new ArrayIndexOutOfBoundsException();
            }
        }
        catch (Exception e) {
            success = false;
            Log.e("GroupSearchSettingActivity", "Results: "+e.getMessage());
            e.printStackTrace();
        }
        finally {
            intent.putExtra(selectedDoneKey, selectedDone);
            intent.putExtra(includedRepeatKey, checkBox.isChecked());
            return success;
        }
    }

}
