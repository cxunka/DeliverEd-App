package com.example.delivered;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity{
    private TextView mainpage,notification,account;
    private TextView settings, settings1;
    private TextView settings2,home,tv_11,tv_12,tv_13,tv_14,tv_15,tv_16,tv_17,tv_18,tv_19,tv_20,tv_21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");


        tv_11 = findViewById(R.id.tv_11);
        tv_11.setTypeface(tf);
        tv_12 = findViewById(R.id.tv_12);
        tv_12.setTypeface(tf);
        tv_13 = findViewById(R.id.tv_13);
        tv_13.setTypeface(tf);
        tv_14 = findViewById(R.id.tv_14);
        tv_14.setTypeface(tf);
        tv_15 = findViewById(R.id.tv_15);
        tv_15.setTypeface(tf);
        tv_16 = findViewById(R.id.tv_16);
        tv_16.setTypeface(tf);
        tv_17 = findViewById(R.id.tv_17);
        tv_17.setTypeface(tf);
        tv_18 = findViewById(R.id.tv_18);
        tv_18.setTypeface(tf);
        tv_19 = findViewById(R.id.tv_19);
        tv_19.setTypeface(tf);
        tv_20 = findViewById(R.id.tv_20);
        tv_20.setTypeface(tf);
        tv_21 = findViewById(R.id.tv_21);
        tv_21.setTypeface(tf);

        settings = findViewById(R.id.settings);
        home = findViewById(R.id.home);
        home.setTypeface(tf);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(SettingsActivity.this, pair1);
                Intent intent = new Intent(SettingsActivity.this, HomePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(SettingsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(SettingsActivity.this, pair1);
                Intent intent = new Intent(SettingsActivity.this, AlertsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(SettingsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(settings, ViewCompat.getTransitionName(settings));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(SettingsActivity.this, pair1, pair2);
                Intent intent = new Intent(SettingsActivity.this, AccountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(SettingsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
    }
}
