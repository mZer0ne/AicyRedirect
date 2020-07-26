package com.meizu.voiceassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pkgString = getPref("redirect_package", this);
        String clsString = getPref("redirect_class", this);
        Intent intent = new Intent(Intent.ACTION_MAIN);

        intent.setComponent(
                new ComponentName(pkgString, clsString)
        );
        startActivity(intent);
        finish();
    }

    public static String getPref(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}