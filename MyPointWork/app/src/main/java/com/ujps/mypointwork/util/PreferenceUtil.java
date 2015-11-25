package com.ujps.mypointwork.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by uilton_santos on 25/11/2015.
 */
public class PreferenceUtil {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String COUNTER_KEY = "counter";
    public static final String DATA_KEY = "counter";

    public static int getSavedCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
        return prefs.getInt(COUNTER_KEY, 0);
    }

    public static void setCounterSharedPreference(Context context, int counter) {

        SharedPreferences.Editor editor = context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE).edit();
        editor.putInt(COUNTER_KEY, counter);
        editor.commit();
    }
}
