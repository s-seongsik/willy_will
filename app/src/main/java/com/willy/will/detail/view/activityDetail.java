package com.willy.will.detail.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.willy.will.R;
import net.daum.mf.map.api.MapView;
import java.util.ArrayList;


public class activityDetail extends Activity {

    ImageView importance;
    TextView itemName, groupName, startDate, endDate, doneDate, roof,achievementRate;
    RelativeLayout achievementRateArea, startDateArea, endDateArea, doneDateArea;
    String roofDay = "";
    String[] days = {"일","월","화","수","목","금","토"};

    int tmpImportance;
    String tmpItemName, tmpGroupName, tmpRoof, tmpDate;
    String[] tmpRoofDay;


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
        tmpDate = "2019-03-03";
        tmpRoof = "0111111";


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
        startDate.setText(tmpDate);
        endDate.setText(tmpDate);
        doneDate.setText(tmpDate);


        //5. set roofDate
        if(tmpRoof.equals("0000000")){ // 안함
            startDateArea.setVisibility(View.GONE);
            endDateArea.setVisibility(View.GONE);
            achievementRateArea.setVisibility(View.GONE);
            roofDay += "안함";
        }else if(tmpRoof.equals("1111111")){ //매일
            doneDateArea.setVisibility(View.GONE);
            roofDay += "매일";
        }else {
            doneDateArea.setVisibility(View.GONE);
            for (int i = 0; i < tmpRoof.length(); i++) {
                if (tmpRoof.charAt(i)-'0'==1) {
                    roofDay += days[i] + " ";
                }
            }
        }
        roof.setText(roofDay);


        //6. set week achievement
/*
        LocalDate today = LocalDate.now();
        String tmp = today.with(previousOrSame(SUNDAY))+"";
        today.with(nextOrSame(SATURDAY));
        // Toast.makeText(this,tmp,Toast.LENGTH_LONG).show();
        //roofDay2[0].setBackgroundResource(R.drawable.gravity1);
        achievementRate.setText(Math.round((rate/7.0)*100) +"%");

*/

        //7. kakao map
        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
        /*
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature: info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        */
    }


    public void backToMain(View view) {
        this.finish();
    }

}

