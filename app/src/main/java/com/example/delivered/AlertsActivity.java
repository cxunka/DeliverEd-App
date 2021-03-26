package com.example.delivered;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
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
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class AlertsActivity extends AppCompatActivity{

    private TextView tv_2,tv_3,tv_7,tv_8,tv_9,tv_10,tv_11,tv_12;
    private TextView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6;
    private TextView btn_20,btn_21,tv_20,tv_21;

    private TextView mainpage,nowlocation,account,notification;

    private TextView home;

    private List<Message> msgList = new ArrayList<>();
    private TextView Btn_sendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        final AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");

        tv_3 = findViewById(R.id.tv_3);
        tv_3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_3.setTypeface(tf);

        notification = findViewById(R.id.notification);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AlertsActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AlertsActivity.this, HomePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(AlertsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });


        nowlocation = findViewById(R.id.nowlocation);
        nowlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlertsActivity.this,"Already in Alerts page.",Toast.LENGTH_SHORT).show();
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AlertsActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AlertsActivity.this, AccountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(AlertsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);

//        initMsg();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MessageAdapter adapter = new MessageAdapter(this, msgList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        Btn_sendRequest = findViewById(R.id.sendRequest);
        Btn_sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = "https://api.particle.io/v1/devices/2b003e000447393035313138";
                // {"arg":"request"}
                String url = "http://httpbin.org/post";
                String json = "{\"arg\":\"request\"}";
                String notification = HttpClient.send(url, json);
                Toast.makeText(AlertsActivity.this,notification,Toast.LENGTH_SHORT).show();
                showResponse(notification);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_alerts);

        final AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");

        tv_3 = findViewById(R.id.tv_3);
        tv_3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_3.setTypeface(tf);

        notification = findViewById(R.id.notification);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AlertsActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AlertsActivity.this, HomePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(AlertsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });


        nowlocation = findViewById(R.id.nowlocation);
        nowlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlertsActivity.this,"Already in Alerts page.",Toast.LENGTH_SHORT).show();
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(nowlocation, ViewCompat.getTransitionName(nowlocation));
                Pair pair3 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AlertsActivity.this, pair1, pair2, pair3);
                Intent intent = new Intent(AlertsActivity.this, AccountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(AlertsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MessageAdapter adapter = new MessageAdapter(this, msgList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        Btn_sendRequest = findViewById(R.id.sendRequest);
        Btn_sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.particle.io/v1/devices/2b003e000447393035313138/LEDStatus";
                // {"arg":"request"}
//                String url = "http://httpbin.org/post";
                String json = "{\"arg\":\"request\"}";
                String notification = HttpClient.send(url, json);
                Toast.makeText(AlertsActivity.this, notification, Toast.LENGTH_SHORT).show();
                System.out.println(notification);
                showResponse(notification);
            }
        });
    }

    private void showResponse(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                changeMsgList(string);
                onResume();
            }
        });
    }

    private static String getTime(){
        LocalDateTime localDateTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            localDateTime = LocalDateTime.now();
        }
        DateTimeFormatter dateTimeFormatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
        }
        String strDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            strDate = localDateTime.format(dateTimeFormatter);
        }
        return strDate;
    }

    private void changeMsgList(String content){
        switch (content) {
            case "02":
            case "0":
                Message locked = new Message("", getTime(), "Your mailbox has been locked!",
                        getResources().getDrawable(R.mipmap.lock1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
                msgList.add(locked);
                Collections.reverse(msgList);
                break;
            case "03":
            case "1":
                Message unlocked = new Message("", getTime(), "Your mailbox was accessed!",
                        getResources().getDrawable(R.mipmap.key1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
                msgList.add(unlocked);
                Collections.reverse(msgList);
                break;
            case "04":
                Message receivedParcel = new Message("", getTime(), "A parcel was delivered to you!",
                        getResources().getDrawable(R.mipmap.parcel1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
                msgList.add(receivedParcel);
                Collections.reverse(msgList);
                break;
            case "10":
                Message full = new Message("", getTime(), "Your mailbox is full!",
                        getResources().getDrawable(R.mipmap.fullmoon1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
                msgList.add(full);
                Collections.reverse(msgList);
                break;
            case "11":
                Message lowCharge = new Message("", getTime(), "Your mailbox is low on battery!",
                        getResources().getDrawable(R.mipmap.lowbattery1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
                msgList.add(lowCharge);
                Collections.reverse(msgList);
                break;
            case "14":
                Message locationChanged = new Message("", getTime(), "Someone tried to move your mailbox!",
                        getResources().getDrawable(R.mipmap.camera1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
                msgList.add(locationChanged);
                Collections.reverse(msgList);
                break;
            case "19":
                Message connect = new Message("", getTime(), "Connected with your mailbox!",
                        getResources().getDrawable(R.mipmap.connect1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
                msgList.add(connect);
                Collections.reverse(msgList);
                break;
            case "20":
                Message disconnect = new Message("", getTime(), "Lost connection with your mailbox!",
                        getResources().getDrawable(R.mipmap.disconnect1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
                msgList.add(disconnect);
                Collections.reverse(msgList);
                break;
            case "23":
                Message resetPassword = new Message("", getTime(), "Reset password successfully!",
                        getResources().getDrawable(R.mipmap.reset1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
                msgList.add(resetPassword);
                Collections.reverse(msgList);
                break;
            case "25":
                Message readyUpdate = new Message("", getTime(), "Software is ready for update!",
                        getResources().getDrawable(R.mipmap.update1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
                msgList.add(readyUpdate);
                Collections.reverse(msgList);
                break;
            case "17":
                Message paired = new Message("", getTime(), "Mailbox has been added to your account!",
                        getResources().getDrawable(R.mipmap.addmailbox1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
                msgList.add(paired);
                Collections.reverse(msgList);
                break;
            case "18":
                Message removed = new Message("", getTime(), "Mailbox has been removed from your account",
                        getResources().getDrawable(R.mipmap.removemailbox1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
                msgList.add(removed);
                Collections.reverse(msgList);
                break;
            case "12":
                Message noCharge = new Message("", getTime(), "Mailbox stops working due to low battery.",
                        getResources().getDrawable(R.mipmap.dead1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
                msgList.add(noCharge);
                Collections.reverse(msgList);
                break;
            case "OK":
                Message ok = new Message("", getTime(), "Succeed: Test Case",
                        getResources().getDrawable(R.mipmap.hand1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
                msgList.add(ok);
                Collections.reverse(msgList);
                break;
            default:
                Message test = new Message("", getTime(), content,
                        getResources().getDrawable(R.mipmap.hand1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
                msgList.add(test);
                Collections.reverse(msgList);
                break;
        }
    }

    private void initMsg() {
        Message locked = new Message("", getTime(), "Your mailbox has been locked!",
                getResources().getDrawable(R.mipmap.lock1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
        msgList.add(locked);
        Message unlocked = new Message("", getTime(), "Your mailbox was accessed!",
                getResources().getDrawable(R.mipmap.key1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
        msgList.add(unlocked);
        Message receivedParcel = new Message("", getTime(), "A parcel was delivered to you!",
                getResources().getDrawable(R.mipmap.parcel1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
        msgList.add(receivedParcel);
        Message full = new Message("", getTime(), "Your mailbox is full!",
                getResources().getDrawable(R.mipmap.fullmoon1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
        msgList.add(full);
        Message lowCharge = new Message("", getTime(), "Your mailbox is low on battery!",
                getResources().getDrawable(R.mipmap.lowbattery1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
        msgList.add(lowCharge);
        Message locationChanged = new Message("", getTime(), "Someone tried to move your mailbox!",
                getResources().getDrawable(R.mipmap.camera1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
        msgList.add(locationChanged);
        Message connect = new Message("", getTime(), "Connected with your mailbox!",
                getResources().getDrawable(R.mipmap.connect1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
        msgList.add(connect);
        Message disconnect = new Message("", getTime(), "Lost connection with your mailbox!",
                getResources().getDrawable(R.mipmap.disconnect1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
        msgList.add(disconnect);
        Message resetPassword = new Message("", getTime(), "Reset password successfully!",
                getResources().getDrawable(R.mipmap.reset1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
        msgList.add(resetPassword);
        Message readyUpdate = new Message("", getTime(), "Software is ready for update!",
                getResources().getDrawable(R.mipmap.update1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
        msgList.add(readyUpdate);
        Message paired = new Message("", getTime(), "Mailbox has been added to your account!",
                getResources().getDrawable(R.mipmap.addmailbox1), getResources().getDrawable(R.drawable.btn_green), View.VISIBLE);
        msgList.add(paired);
        Message removed = new Message("", getTime(), "Mailbox has been removed from your account",
                getResources().getDrawable(R.mipmap.removemailbox1), getResources().getDrawable(R.drawable.btn_1), View.VISIBLE);
        msgList.add(removed);
        Message noCharge = new Message("", getTime(), "Mailbox stops working due to low battery.",
                getResources().getDrawable(R.mipmap.dead1), getResources().getDrawable(R.drawable.btn_red), View.VISIBLE);
        msgList.add(noCharge);
    }
}