package com.example.willy_will;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;


public class activityDetail extends Activity {
    ImageView importance;
    TextView itemName, groupName, startDate, endDate, doneDate, roof,achievementRate,sun;
    RelativeLayout achievementRateArea, doneDateArea;
    int importanceValue;
    Date date;
    String[] roofstr;
    String roofDay;
    int rate;
    Intent intent;
    String[]  days = {"일","월","화","수","목","금","토"};
    ImageButton back_button;
    //MapView mapView;
    ViewGroup mapViewContainer;
    ArrayList<TextView> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //list.indexOf(findViewById(R.id.textView));


        importance = findViewById(R.id.importance);
        itemName = findViewById(R.id.itemName);
        groupName = findViewById(R.id.groupName);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        doneDate = findViewById(R.id.doneDate);
        roof = findViewById(R.id.roof);
        achievementRateArea = findViewById(R.id.achievementRateArea);
        doneDateArea = findViewById(R.id.doneDateArea);
        achievementRate = findViewById(R.id.achievementRate);
        back_button = findViewById(R.id.back_button);
        mapViewContainer = findViewById(R.id.map_view);
        sun = findViewById(R.id.sun);
       // roofDay2[1] = findViewById(R.id.mon);

        //itemId 가져와서 데이터 뿌려주기
        intent = getIntent();
        int itemId = intent.getIntExtra("itemId",-1);

        //itemId(현재는 그냥 변수에 값 넣어서 테스트 중..)
        date = new Date();
        roofstr = "0111111".split("");
        roofDay = "";


        // 할일 이름
        itemName.setText(itemId+"안녕");
        groupName.setText("안녕");
        startDate.setText(date + "");
        endDate.setText(date + "");
        doneDate.setText(date + "");






        //초기화
        rate = 0;




        // 중요도
        if(importanceValue==1) {
            importance.setImageResource(R.drawable.gravity1);
        }else if(importanceValue==2){
            importance.setImageResource(R.drawable.gravity1);
        }else if(importanceValue==3){
            importance.setImageResource(R.drawable.gravity1);
        }else {
            importance.setVisibility(View.GONE);
        }





        if(roofstr.equals("0000000")){
            achievementRateArea.setVisibility(View.GONE);
        }else if(roofstr.equals("1111111")){
            roofDay += "매일";
            doneDateArea.setVisibility(View.GONE);
        }else{
            doneDateArea.setVisibility(View.GONE);
            for(int i=0;i<roofstr.length-1;i++){
                if(roofstr[i].equals("1")){
                    roofDay += days[i] + " ";
                    rate++;
                }
            }
        }



        roof.setText(roofDay);
        achievementRate.setText(Math.round((rate/7.0)*100) +"%");


        LocalDate today = LocalDate.now();
        String tmp = today.with(previousOrSame(SUNDAY))+"";
        today.with(nextOrSame(SATURDAY));
        //오늘 날짜를 기준으로 일주일 안에 해당하는 아이템들을 가져온
       // Toast.makeText(this,tmp,Toast.LENGTH_LONG).show();
        //roofDay2[0].setBackgroundResource(R.drawable.gravity1);



        //구글맵

/*
        mapView = new MapView(this);
        mapViewContainer.addView(mapView);
        *?
 */




    }


}
