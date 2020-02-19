package com.willy.will.detail.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.willy.will.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;
import java.util.ArrayList;


public class activityDetail extends Activity {

    ImageView importance;
    TextView itemName, groupName, startDate, endDate, doneDate, roof,achievementRate;
    RelativeLayout achievementRateArea, startDateArea, endDateArea, doneDateArea;
    String roofDay = "";
    String[] days = {"일","월","화","수","목","금","토"};
    MapPoint markerPoint;

    int tmpImportance;
    String tmpItemName, tmpGroupName, tmpRoof, tmpDate;
    String[] tmpRoofDay;

    /**
     * Last Modified: 2020-02-19
     * Last Modified By: Kim Mikyung
     * Created: -
     * Created By: -
     * @param savedInstanceState
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
        tmpDate = "2019-03-03";
        tmpRoof = "0111111";
        markerPoint = MapPoint.mapPointWithGeoCoord(37.4020737, 127.1086766);


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

        mapView.setMapCenterPoint(markerPoint, true);
        //mapView.setZoomLevel(7, true);
        //mapView.zoomIn(true);
        //mapView.zoomOut(true);

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(markerPoint);
        //marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        //marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);



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

    /**
     * Last Modified: 2020-02-20
     * Last Modified By: -
     * Created: 2020-02-17
     * Created By: Kim Mikyung
     * Function: Back to BaseActivity (Main View)
     * Called when the user taps the back_button
     * @param view
     */
    public void backToMain(View view) {
        // Check focusing
        View focusedView = getCurrentFocus();
        if(focusedView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        // ~Check focusing
        this.finish();
    }

}

