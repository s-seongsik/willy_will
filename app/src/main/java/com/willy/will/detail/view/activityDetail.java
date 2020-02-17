package com.willy.will.detail.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import com.willy.will.R;

import net.daum.mf.map.api.MapView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;


public class activityDetail extends Activity {

    ImageView importance;
    TextView itemName, groupName, startDate, endDate, doneDate, roof,achievementRate;
    RelativeLayout achievementRateArea, startDateArea, endDateArea, doneDateArea;
    String roofDay = "";
    String[] days = {"일","월","화","수","목","금","토"};
    int rate = 0;

    int tmpImportance;
    String tmpItemName, tmpGroupName, tmpRoof;
    String[] tmpRoofDay;
    Date tmpDate;

    /*
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
    MapView mapView;
    ViewGroup mapViewContainer;
    ArrayList<TextView> list = new ArrayList<TextView>();
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // findViewById
        importance = findViewById(R.id.importance);
        itemName = findViewById(R.id.itemName);
        groupName = findViewById(R.id.groupName);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        doneDate = findViewById(R.id.doneDate);
        achievementRate = findViewById(R.id.achievementRate);
        achievementRateArea = findViewById(R.id.achievementRateArea);
        startDateArea = findViewById(R.id.startDateArea);
        endDateArea = findViewById(R.id.endDateArea);
        doneDateArea = findViewById(R.id.doneDateArea);
        roof = findViewById(R.id.roof);



        // db data
            //intent = getIntent();
            //int itemId = intent.getIntExtra("itemId",-1);
        tmpImportance = 0;
        tmpItemName = "취뽀 프로젝트";
        tmpGroupName = "willy";
        tmpDate = new Date();
        tmpRoof = "1010101";
        tmpRoofDay = tmpRoof.split("");




        // 1. set importance
        if(tmpImportance==1) {
            importance.setImageResource(R.drawable.gravity1);
        }else if(tmpImportance==2){
            importance.setImageResource(R.drawable.gravity1);
        }else if(tmpImportance==3){
            importance.setImageResource(R.drawable.gravity1);
        }else {
            importance.setVisibility(View.GONE);
        }


        //2. set itemName, groupname
        itemName.setText(tmpItemName);
        itemName.setText(tmpGroupName);


        //******** 3. set groupColor


        //4 set date
        SimpleDateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
        startDate.setText(dateFomat.format(tmpDate));
        endDate.setText(dateFomat.format(tmpDate));
        doneDate.setText(dateFomat.format(tmpDate));

        String result = "";

        //5. set roofDate
        //tmpRoof = "0000000";
        //tmpRoofDay = tmpRoof.split("");
        if(tmpRoof.equals("0000000")){ // 안함
            startDateArea.setVisibility(View.GONE);
            endDateArea.setVisibility(View.GONE);
            achievementRateArea.setVisibility(View.GONE);
            roofDay += "안함";
        }else if(tmpRoof.equals("1111111")){ //매일
            doneDateArea.setVisibility(View.GONE);
            roofDay += "매일";
        }else{
            //tmpRoofDay.setVisibility(View.GONE);

            for(int i=0;i<tmpRoofDay.length-1;i++){
                /*
                if(tmpRoofDay[i] == null){
                    result += "n;ll";
                }else if(tmpRoofDay[i].equals("1")){
                    roofDay += days[i] + " ";
                    rate++;
                }

                 */
            }

        }
        roof.setText(roofDay);
        achievementRate.setText(Math.round((rate/7.0)*100) +"%");



        //6. set week achievement



        //7. kakao map


        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);



    }

    public void backToMain(View view) {
        this.finish();
    }


}

