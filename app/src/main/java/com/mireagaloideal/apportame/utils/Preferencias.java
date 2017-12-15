package com.mireagaloideal.apportame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.mireagaloideal.apportame.App;
import com.mireagaloideal.apportame.data.RegaloFromWS;

import static com.mireagaloideal.apportame.utils.Constants.REGALO_PREFS;

/**
 * Created by Jordán Rosas on 14/12/2017.
 */

public class Preferencias {
    private static Preferencias preferences;
    private SharedPreferences mSharedPreferences;

    private Preferencias(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.SETTINGS_NAME, Context.MODE_PRIVATE);
    }

    public static Preferencias getInstance(Context context) {
        if (preferences == null) {
            preferences = new Preferencias(context.getApplicationContext());
        }
        return preferences;
    }

    public static Preferencias getInstance() {
        if (preferences != null) {
            return preferences;
        } else {
            return new Preferencias(App.getContext());
        }
    }

    public String getString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

    public RegaloFromWS getRegalo() {
        String regStr = this.mSharedPreferences.getString(REGALO_PREFS, "");
        //RegaloFromWS regalo = new RegaloFromWS();
        if (TextUtils.isEmpty(regStr)) {
            return null;
        } else {
            return new Gson().fromJson(regStr, RegaloFromWS.class);
        }
    }

    public void saveRegalo(RegaloFromWS regaloFromWS) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString(REGALO_PREFS, new Gson().toJson(regaloFromWS));
        editor.commit();
    }
}
