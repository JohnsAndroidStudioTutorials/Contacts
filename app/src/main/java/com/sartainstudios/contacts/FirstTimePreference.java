package com.sartainstudios.contacts;

/**
 * Created by John Sartain on 8/4/2015.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 *         <p/>
 *         Example.
 *         FirstTimePreference prefFirstTime = new FirstTimePreference(getApplicationContext());
 *         if (prefFirstTime.runTheFirstNTimes("myKey" , 3)) {
 *         Toast.makeText(this,"Test myKey & coutdown: "+ prefFirstTime.getCountDown("myKey"),Toast.LENGTH_LONG).show(); }
 */

public class FirstTimePreference {

    private static final int INT_ERROR = -1;
    public static final String FIRST_TIME_PREFERENCES_KEY = "FirstKeyPreferences";
    public static final String FIRST_TIME_COUNTDOWN_KEY = "FirstCountdownKey";
    private final SharedPreferences firstTimePreferences;

    public FirstTimePreference(Context context) {
        firstTimePreferences = context.getSharedPreferences(
                FIRST_TIME_PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    /**
     * @param key
     * @return the how many times the code will be executed yet
     */
    public int getCountDown(String key) {
        return firstTimePreferences.getInt(key + FIRST_TIME_COUNTDOWN_KEY,
                INT_ERROR);
    }

    /**
     * @param key - Countdown default 0
     * @return true the first time
     */
    public boolean runTheFirstTime(String key) {
        return runTheFirstNTimes(key, 0);
    }

    /**
     * @param key
     * @param countdown
     * @return true for the first <countdown> times
     */
    public boolean runTheFirstNTimes(String key, int countdown) {
        int countDownPref = getCountDown(key);

        switch (countDownPref) {
            case 0:
                setFalse(key);
                break;

            case INT_ERROR:
                if (countdown != 0) {
                    setCountDown(key, countdown - 1);
                } else {
                    setCountDown(key, 0);
                }
                break;

            default:
                setCountDown(key, countDownPref - 1);
                break;
        }

        boolean actionResult = firstTimePreferences.getBoolean(key, true);
        return actionResult;
    }

    private void setFalse(String key) {
        SharedPreferences.Editor editor = firstTimePreferences.edit();
        editor.putBoolean(key, false);
        editor.commit();
    }

    private void setCountDown(String key, int countDown) {
        SharedPreferences.Editor editor = firstTimePreferences.edit();
        editor.putInt(key + FIRST_TIME_COUNTDOWN_KEY, countDown);
        editor.commit();
    }

}