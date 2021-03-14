package com.example.delivered;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DevicePageActivity extends AppCompatActivity {

    private TextView tv_7;
    private TextView tv_8,tv_10,tv_9,tv_11;
    private RadioGroup mRg1;
    private RadioButton lock_device, open_device;
    private TextView mainpage,notification,account;
    private TextView home,DHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_page);
        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");
        tv_7 = findViewById(R.id.tv_7);
        tv_7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DevicePageActivity.this,"Uploading photo is still building.",Toast.LENGTH_SHORT).show();
            }
        });
        tv_7.setTypeface(tf);
        tv_8 = findViewById(R.id.tv_8);
        tv_8.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_8.setTypeface(tf);
        tv_10 = findViewById(R.id.tv_10);
        tv_10.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_10.setTypeface(tf);

        mRg1 = findViewById(R.id.mRg1);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(DevicePageActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------
        open_device = findViewById(R.id.open_device);
        open_device.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Post post = new Post();
                post.run(1);
                Toast.makeText(DevicePageActivity.this, "Successfully open device!", Toast.LENGTH_SHORT).show();
            }
        });
        lock_device = findViewById(R.id.lock_device);
        lock_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.run(0);
                Toast.makeText(DevicePageActivity.this, "Successfully lock device!", Toast.LENGTH_SHORT).show();
            }
        });
        open_device.setTypeface(tf);
        lock_device.setTypeface(tf);
        //-----------------------------------------
        tv_9 = findViewById(R.id.tv_9);
        tv_9.setTypeface(tf);
        tv_11 = findViewById(R.id.tv_11);
        tv_11.setTypeface(tf);

        DHome = findViewById(R.id.DHome);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                Pair pair2 = new Pair<>(DHome, ViewCompat.getTransitionName(DHome));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(DevicePageActivity.this, pair1, pair2);
                Intent intent = new Intent(DevicePageActivity.this, HomePageActivity.class);
                ActivityCompat.startActivity(DevicePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(DevicePageActivity.this, pair1);
                Intent intent = new Intent(DevicePageActivity.this, AlertsActivity.class);
                ActivityCompat.startActivity(DevicePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(DevicePageActivity.this, pair1);
                Intent intent = new Intent(DevicePageActivity.this, AccountActivity.class);
                ActivityCompat.startActivity(DevicePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);
    }
}
