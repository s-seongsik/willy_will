package com.willy.will.search.model;

import android.content.res.Resources;
import android.util.Log;

import com.willy.will.R;
import com.willy.will.common.controller.App;

import java.util.ArrayList;

public class DistanceSet {

    public static ArrayList<Distance> distances = new ArrayList<>();

    static {
        Resources resources = App.getContext().getResources();

        int[] lengthArr = resources.getIntArray(R.array.length_list);
        int[] lengthUseArr = resources.getIntArray(R.array.length_use_list);

        int size = lengthArr.length;
        if (size == lengthUseArr.length) {
            final int EQUIVALENCE = resources.getInteger(R.integer.equivalence_to_long);
            String shortUnit = resources.getString(R.string.unit_short);
            String longUnit = resources.getString(R.string.unit_long);
            String basicText = resources.getString(R.string.distance_text);

            distances.add(new Distance(resources.getString(R.string.all), true));

            String text = null;
            int length = 0;
            for(int i = 0; i < size; i++) {
                length = lengthArr[i];
                if(length < EQUIVALENCE) {
                    text = String.format(basicText, length, shortUnit);
                } else {
                    text = String.format(basicText, (length / EQUIVALENCE), longUnit);
                }

                if(lengthUseArr[i] > 0) {
                    distances.add(new Distance(text, true));
                }
                else {
                    distances.add(new Distance(text, false));
                }
            }
        }
        else {
            Log.e("DistanceSet", "The size of Length List and the size of Length Use List are different.");
        }
    }

}
