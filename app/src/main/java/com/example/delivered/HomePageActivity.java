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

public class HomePageActivity extends AppCompatActivity {

    private TextView tv_2;
    private TextView nowlocation,notification,account,mainpage;
    private TextView home;

    private Button DHome,btn_2,btn_3;
    private Button btn_11,btn_111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv_2 = findViewById(R.id.tv_2);
        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");
        tv_2.setTypeface(tf);
        mainpage = findViewById(R.id.mainpage);
        nowlocation = findViewById(R.id.nowlocation);
        nowlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePageActivity.this,"Already in Home page.",Toast.LENGTH_SHORT).show();
            }
        });
        notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(HomePageActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(HomePageActivity.this, AlertsActivity.class);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(HomePageActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(HomePageActivity.this, AccountActivity.class);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });


        DHome = findViewById(R.id.DHome);
        DHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(DHome, ViewCompat.getTransitionName(DHome));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(HomePageActivity.this, pair1);
                Intent intent = new Intent(HomePageActivity.this, DevicePageActivity.class);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        DHome.setTypeface(tf);

        btn_11 = findViewById(R.id.btn_11);
        btn_11.setTypeface(tf);
        btn_111 = findViewById(R.id.btn_111);
        btn_111.setTypeface(tf);

        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePageActivity.this,"Adding Device is still building.",Toast.LENGTH_SHORT).show();
            }
        });
        btn_2.setTypeface(tf);

        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePageActivity.this,"Removing Device is still building.",Toast.LENGTH_SHORT).show();
            }
        });
        btn_3.setTypeface(tf);

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);


    }
}
