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

import java.util.ArrayList;
import java.util.List;

public class AlertsActivity extends AppCompatActivity{

    private TextView tv_2,tv_3,tv_7,tv_8,tv_9,tv_10,tv_11,tv_12;
    private TextView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6;
    private TextView btn_20,btn_21,tv_20,tv_21;

    private TextView mainpage,nowlocation,account,notification;

    private TextView home;

    private List<Message> msgList = new ArrayList<>();

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
                ActivityCompat.startActivity(AlertsActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);

        initMsg();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MessageAdapter adapter = new MessageAdapter(this, msgList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void initMsg() {
        Message locked = new Message("", "00:00", "Your mailbox has been locked!",
                getResources().getDrawable(R.mipmap.lock1), getResources().getDrawable(R.drawable.btn_1));
        msgList.add(locked);
        Message unlocked = new Message("", "00:00", "Your mailbox was accessed!",
                getResources().getDrawable(R.mipmap.key1), getResources().getDrawable(R.drawable.btn_green));
        msgList.add(unlocked);
        Message receivedParcel = new Message("", "00:00", "A parcel was delivered to you!",
                getResources().getDrawable(R.mipmap.parcel1), getResources().getDrawable(R.drawable.btn_green));
        msgList.add(receivedParcel);
        Message full = new Message("", "00:00", "Your mailbox is full!",
                getResources().getDrawable(R.mipmap.fullmoon1), getResources().getDrawable(R.drawable.btn_red));
        msgList.add(full);
        Message lowCharge = new Message("", "00:00", "Your mailbox is low on battery!",
                getResources().getDrawable(R.mipmap.lowbattery1), getResources().getDrawable(R.drawable.btn_red));
        msgList.add(lowCharge);
        Message locationChanged = new Message("", "00:00", "Someone tried to move your mailbox!",
                getResources().getDrawable(R.mipmap.camera1), getResources().getDrawable(R.drawable.btn_red));
        msgList.add(locationChanged);
        Message connect = new Message("", "00:00", "Connected with your mailbox!",
                getResources().getDrawable(R.mipmap.connect1), getResources().getDrawable(R.drawable.btn_1));
        msgList.add(connect);
        Message disconnect = new Message("", "00:00", "Lost connection with your mailbox!",
                getResources().getDrawable(R.mipmap.disconnect1), getResources().getDrawable(R.drawable.btn_red));
        msgList.add(disconnect);
        Message resetPassword = new Message("", "00:00", "Reset password successfully!",
                getResources().getDrawable(R.mipmap.reset1), getResources().getDrawable(R.drawable.btn_green));
        msgList.add(resetPassword);
        Message readyUpdate = new Message("", "00:00", "Software is ready for update!",
                getResources().getDrawable(R.mipmap.update1), getResources().getDrawable(R.drawable.btn_1));
        msgList.add(readyUpdate);
        Message paired = new Message("", "00:00", "Mailbox has been added to your account!",
                getResources().getDrawable(R.mipmap.addmailbox1), getResources().getDrawable(R.drawable.btn_green));
        msgList.add(paired);
        Message removed = new Message("", "00:00", "Mailbox has been removed from your account",
                getResources().getDrawable(R.mipmap.removemailbox1), getResources().getDrawable(R.drawable.btn_1));
        msgList.add(removed);
        Message noCharge = new Message("", "00:00", "Mailbox stops working due to low battery.",
                getResources().getDrawable(R.mipmap.dead1), getResources().getDrawable(R.drawable.btn_red));
        msgList.add(noCharge);
    }
}
