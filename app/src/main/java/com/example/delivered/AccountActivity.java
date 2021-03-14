package com.example.delivered;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    private TextView tv_2,tv_7;
    private Button btn_1,btn_2;

    private TextView mainpage,notification,nowlocation,account;

    private TextView home;
    private Button userguide;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");

        tv_7 = findViewById(R.id.tv_7);
        tv_7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_7.setTypeface(tf);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountActivity.this,"Editing Details is still building.",Toast.LENGTH_SHORT).show();
            }
        });
        btn_1.setTypeface(tf);

        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountActivity.this,"Successfully Log off.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btn_2.setTypeface(tf);

        account = findViewById(R.id.account);

        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(account, ViewCompat.getTransitionName(account));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AccountActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AccountActivity.this, HomePageActivity.class);
                ActivityCompat.startActivity(AccountActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(account, ViewCompat.getTransitionName(account));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AccountActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AccountActivity.this, AlertsActivity.class);
                ActivityCompat.startActivity(AccountActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        nowlocation = findViewById(R.id.nowlocation);
        nowlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountActivity.this,"Already in Account page.",Toast.LENGTH_SHORT).show();
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);

        userguide = findViewById(R.id.userguide);
        userguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(userguide, ViewCompat.getTransitionName(userguide));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AccountActivity.this, pair1);
                Intent intent = new Intent(AccountActivity.this, UserGuideActivity.class);
                ActivityCompat.startActivity(AccountActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        userguide.setTypeface(tf);

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(settings, ViewCompat.getTransitionName(settings));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AccountActivity.this, pair1);
                Intent intent = new Intent(AccountActivity.this, SettingsActivity.class);
                ActivityCompat.startActivity(AccountActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        settings.setTypeface(tf);

    }
}
