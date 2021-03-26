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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
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
    private Button btn_D1, btn_D2, btn_D3, btn_D4;
    private List<DHome> dHomeList = new ArrayList<>();
    private LinearLayout device_list;

    private Button fullbutton,fullbutton1,fullbutton2;
    private RadioButton open, close;
    private RadioButton open1, close1;
    private RadioButton open2, close2;
    private Button remove, remove1, remove2;

    private RelativeLayout r0, r1, r2;

    private TextView t1, t2, t3;

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

        fullbutton = findViewById(R.id.fullbutton);
        fullbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DevicePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        fullbutton.setTypeface(tf);

        fullbutton1 = findViewById(R.id.fullbutton1);
        fullbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DevicePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        fullbutton1.setTypeface(tf);
        fullbutton2 = findViewById(R.id.fullbutton2);
        fullbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DevicePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        fullbutton2.setTypeface(tf);

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

        r0 = findViewById(R.id.DHome);
        r0.setVisibility(GONE);
        r1 = findViewById(R.id.DHome1);
        r1.setVisibility(GONE);
        r2 = findViewById(R.id.DHome2);
        r2.setVisibility(GONE);

        open = findViewById(R.id.open_device);
        open1 = findViewById(R.id.open_device1);
        open2 = findViewById(R.id.open_device2);
        open.setTypeface(tf);
        open1.setTypeface(tf);
        open2.setTypeface(tf);
        open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Post post = new Post();
                post.run(1);
                Toast.makeText(HomePageActivity.this, "Successfully open device!", Toast.LENGTH_SHORT).show();
            }
        });
        open1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Post post = new Post();
                post.run(1);
                Toast.makeText(HomePageActivity.this, "Successfully open device!", Toast.LENGTH_SHORT).show();
            }
        });
        open2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Post post = new Post();
                post.run(1);
                Toast.makeText(HomePageActivity.this, "Successfully open device!", Toast.LENGTH_SHORT).show();
            }
        });

        close = findViewById(R.id.lock_device);
        close1 = findViewById(R.id.lock_device1);
        close2 = findViewById(R.id.lock_device2);
        close.setTypeface(tf);
        close1.setTypeface(tf);
        close2.setTypeface(tf);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.run(0);
                Toast.makeText(HomePageActivity.this, "Successfully lock device!", Toast.LENGTH_SHORT).show();
            }
        });
        close1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.run(0);
                Toast.makeText(HomePageActivity.this, "Successfully lock device!", Toast.LENGTH_SHORT).show();
            }
        });
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.run(0);
                Toast.makeText(HomePageActivity.this, "Successfully lock device!", Toast.LENGTH_SHORT).show();
            }
        });

        remove = findViewById(R.id.remove);
        remove1 = findViewById(R.id.remove1);
        remove2 = findViewById(R.id.remove2);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r0.setVisibility(GONE);
            }
        });

        remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setVisibility(GONE);
            }
        });

        remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setVisibility(GONE);
            }
        });

        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text11);
        t3 = findViewById(R.id.text12);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String id = intent.getStringExtra("msg");
        if (id != null){
            if (id.equals("remove r0")){
                r0.setVisibility(GONE);
                id = null;
            }else if (r0.getVisibility() == GONE) {
                r0.setVisibility(VISIBLE);
                String str = "      DHome ID: " + id;
                t1.setText(str);
                id = null;
            } else if (r1.getVisibility() == GONE) {
                r1.setVisibility(VISIBLE);
                String str = "      DHome ID: " + id;
                t2.setText(str);
                id = null;
            } else if (r2.getVisibility() == GONE) {
                r2.setVisibility(VISIBLE);
                String str = "      DHome ID: " + id;
                t3.setText(str);
                id = null;
            }
        }
//        Toast.makeText(HomePageActivity.this,id,Toast.LENGTH_SHORT).show();
//        if (id != null){
//            switch (id) {
//                case "DHome \n          123456":
//                    DHome.setVisibility(GONE);
//                    id = null;
//                    break;
//                case "DHome \n          00001":
//                    btn_D1.setVisibility(GONE);
//                    id = null;
//                    break;
//                case "DHome \n          00002":
//                    btn_D2.setVisibility(GONE);
//                    id = null;
//                    break;
//                case "DHome \n          00003":
//                    btn_D3.setVisibility(GONE);
//                    id = null;
//                    break;
//                case "DHome \n          00004":
//                    btn_D4.setVisibility(GONE);
//                    id = null;
//                    break;
//                default:
//                    if (DHome.getVisibility() == GONE) {
//                        DHome.setVisibility(VISIBLE);
//                        String str = "DHome \n          " + id;
//                        DHome.setText(str);
//                        id = null;
//                    } else if (btn_D1.getVisibility() == GONE) {
//                        btn_D1.setVisibility(VISIBLE);
//                        String str = "DHome \n          " + id;
//                        btn_D1.setText(str);
//                        id = null;
//                    } else if (btn_D2.getVisibility() == GONE) {
//                        btn_D2.setVisibility(VISIBLE);
//                        String str = "DHome \n          " + id;
//                        btn_D2.setText(str);
//                        id = null;
//                    } else if (btn_D3.getVisibility() == GONE) {
//                        btn_D3.setVisibility(VISIBLE);
//                        String str = "DHome \n          " + id;
//                        btn_D3.setText(str);
//                        id = null;
//                    } else if (btn_D4.getVisibility() == GONE) {
//                        btn_D4.setVisibility(VISIBLE);
//                        String str = "DHome \n          " + id;
//                        btn_D4.setText(str);
//                        id = null;
//                    }
//                    break;
//            }
//        }
    }
}
