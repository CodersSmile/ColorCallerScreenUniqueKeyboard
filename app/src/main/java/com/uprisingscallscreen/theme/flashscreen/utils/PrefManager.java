package com.uprisingscallscreen.theme.flashscreen.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;


public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "festival_pref";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setBoolean(String PREF_NAME,Boolean val) {
        editor.putBoolean(PREF_NAME, val);
        editor.commit();
    }
    public void setString(String PREF_NAME,String VAL) {
        editor.putString(PREF_NAME, VAL);
        editor.commit();
    }
    public void setInt(String PREF_NAME,int VAL) {
        editor.putInt(PREF_NAME, VAL);
        editor.commit();
    }
    public boolean getBoolean(String PREF_NAME) {
        return pref.getBoolean(PREF_NAME,false);
    }

    public void remove(String PREF_NAME){
        if(pref.contains(PREF_NAME)){
            editor.remove(PREF_NAME);
            editor.commit();
        }
    }
    public String getString(String PREF_NAME) {
        if(pref.contains(PREF_NAME)){
            return pref.getString(PREF_NAME,null);
        }
        return  "";
    }

    public int getInt(String key) {
        return pref.getInt(key,0);
    }
    private static void runOnUiThread(Runnable action) {
        // Check if we're already on the main thread
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            // If we're already on the main thread, just run the action
            action.run();
        } else {
            // If we're not on the main thread, post the action to the main thread's message queue
            new Handler(Looper.getMainLooper()).post(action);
        }
    }
}
