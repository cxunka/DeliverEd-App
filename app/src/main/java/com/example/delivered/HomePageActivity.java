package com.example.delivered;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HomePageActivity extends AppCompatActivity {

    private TextView tv_2;
    private TextView nowlocation,notification,account,mainpage;
    private TextView home;

    private Button Adddevice;
    private Button DHome, btn_D1, btn_D2, btn_D3, btn_D4;
    private List<DHome> dHomeList = new ArrayList<>();
    private LinearLayout device_list;

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
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

//        device_list = findViewById(R.id.device_list);

        DHome = findViewById(R.id.DHome);
        DHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(DHome, ViewCompat.getTransitionName(DHome));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(HomePageActivity.this, pair1);
                Intent intent = new Intent(HomePageActivity.this, DevicePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        DHome.setTypeface(tf);

        btn_D1 = findViewById(R.id.DHome1);
        btn_D1.setTypeface(tf);
        btn_D2 = findViewById(R.id.DHome2);
        btn_D2.setTypeface(tf);
        btn_D3 = findViewById(R.id.DHome3);
        btn_D3.setTypeface(tf);
        btn_D4 = findViewById(R.id.DHome4);
        btn_D4.setTypeface(tf);

        Adddevice = findViewById(R.id.Adddevice);
        Adddevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(Adddevice, ViewCompat.getTransitionName(Adddevice));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(HomePageActivity.this, pair1);
                Intent intent = new Intent(HomePageActivity.this, AddDeviceActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(HomePageActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        Adddevice.setTypeface(tf);


        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String id = intent.getStringExtra("msg");
//        Toast.makeText(HomePageActivity.this,id,Toast.LENGTH_SHORT).show();
        if (id != null){
            switch (id) {
                case "DHome \n          123456":
                    DHome.setVisibility(GONE);
                    id = null;
                    break;
                case "DHome \n          00001":
                    btn_D1.setVisibility(GONE);
                    id = null;
                    break;
                case "DHome \n          00002":
                    btn_D2.setVisibility(GONE);
                    id = null;
                    break;
                case "DHome \n          00003":
                    btn_D3.setVisibility(GONE);
                    id = null;
                    break;
                case "DHome \n          00004":
                    btn_D4.setVisibility(GONE);
                    id = null;
                    break;
                default:
                    if (DHome.getVisibility() == GONE) {
                        DHome.setVisibility(VISIBLE);
                        String str = "DHome \n          " + id;
                        DHome.setText(str);
                        id = null;
                    } else if (btn_D1.getVisibility() == GONE) {
                        btn_D1.setVisibility(VISIBLE);
                        String str = "DHome \n          " + id;
                        btn_D1.setText(str);
                        id = null;
                    } else if (btn_D2.getVisibility() == GONE) {
                        btn_D2.setVisibility(VISIBLE);
                        String str = "DHome \n          " + id;
                        btn_D2.setText(str);
                        id = null;
                    } else if (btn_D3.getVisibility() == GONE) {
                        btn_D3.setVisibility(VISIBLE);
                        String str = "DHome \n          " + id;
                        btn_D3.setText(str);
                        id = null;
                    } else if (btn_D4.getVisibility() == GONE) {
                        btn_D4.setVisibility(VISIBLE);
                        String str = "DHome \n          " + id;
                        btn_D4.setText(str);
                        id = null;
                    }
                    break;
            }
        }
    }
}
