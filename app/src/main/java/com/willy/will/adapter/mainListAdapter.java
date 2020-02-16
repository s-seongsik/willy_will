package com.willy.will.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import androidx.core.content.ContextCompat;

import com.willy.will.R;
import com.willy.will.main.model.mainListItem;

import java.io.Serializable;
import java.util.ArrayList;

public class mainListAdapter extends BaseAdapter implements Serializable {

    /* 아이템을 세트로 담기 위한 어레이 */
    private transient ArrayList<mainListItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public mainListItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        CheckBox cb_done = (CheckBox) convertView.findViewById(R.id.cb_done);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name) ;
        TextView tv_date = (TextView) convertView.findViewById(R.id.tv_time) ;
        //TextView tv_routine = (TextView) convertView.findViewById(R.id.tv_routine);
        TextView tv_rank = (TextView) convertView.findViewById(R.id.tv_rank);



        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        mainListItem item = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        tv_name.setText(item.getName());
        tv_date.setText(item.getTime());
        //tv_routine.setText(item.getRoutine());
        tv_rank.setText(item.getRank());

        //setting color behind task text
        Spannable span = (Spannable) tv_name.getText();
        span.setSpan(
                new BackgroundColorSpan(ContextCompat.getColor(convertView.getContext(),R.color.colorGroup1))
                ,0
                , tv_name.length()
                ,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..) */
        //done taking
        if(cb_done.isChecked()){
            span.setSpan(
                    new BackgroundColorSpan(ContextCompat.getColor(convertView.getContext(),R.color.colorInactive))
                    ,0
                    , tv_name.length()
                    ,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            tv_name.setPaintFlags(tv_name.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            tv_rank.setPaintFlags(tv_rank.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }

        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(String rank, String name, String time /*,CheckBox done,String routine*/) {

        mainListItem mItem = new mainListItem();

        /* MyItem에 아이템을 setting한다. */
        mItem.setRank(rank);
        mItem.setName(name);
        mItem.setTime(time);
        //mItem.setDone(done);
        //mItem.setRoutine(routine);

        /* mItems에 MyItem을 추가한다. */
        mItems.add(mItem);

    }
}
