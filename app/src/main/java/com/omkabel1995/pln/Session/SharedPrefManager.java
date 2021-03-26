package com.omkabel1995.pln.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_LOGIN_APP = "Apps";
    public static final String SP_Username= "spUsername";
    public static final String SP_Password = "spPassword";
    public static final String SP_Status= "spStatus";
    public static final String SP_SUDAH_LOGIN = "SudahLogin";
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_LOGIN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }
    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }
    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }
    public String getSP_Username(){
        return sp.getString(SP_Username, "");
    }
    public String getSP_Password(){
        return sp.getString(SP_Password, "");
    }
    public String getSP_Status(){
        return sp.getString(SP_Status, "");
    }
    public Boolean getSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
