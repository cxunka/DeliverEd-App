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
    private TextView settings0, settings1;
    private TextView settings2,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");

        settings0 = findViewById(R.id.settings0);
        settings1 = findViewById(R.id.settings1);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(SettingsActivity.this, pair1);
                Intent intent = new Intent(SettingsActivity.this, HomePageActivity.class);
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
                ActivityCompat.startActivity(SettingsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(settings0, ViewCompat.getTransitionName(settings0));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(SettingsActivity.this, pair1, pair2);
                Intent intent = new Intent(SettingsActivity.this, AccountActivity.class);
                ActivityCompat.startActivity(SettingsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
    }
}
