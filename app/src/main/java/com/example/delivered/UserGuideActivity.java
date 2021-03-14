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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class UserGuideActivity extends AppCompatActivity {

    private TextView mainpage,notification,account;
    private TextView userguide,home;

    private Button btn_1;
    private TextView tv_1,tv_3;
    private EditText et_1;

    private static final String[] strs = new String[] {
        "How do I access my device?\n\nYou can...", "How do I know my parcel delivered?\n\nYou can...",
            "How do I...\n\nYou can...", "How do I...\n\nYou can...", "How do I...\n\nYou can...",
            "How do I...\n\nYou can...", "How do I...\n\nYou can...", "How do I...\n\nYou can..."
    };
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");

        lv = findViewById(R.id.listview);

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strs));



        tv_1 = findViewById(R.id.tv_1);
        tv_1.setTypeface(tf);
        tv_3 = findViewById(R.id.tv_3);
        tv_3.setTypeface(tf);
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_1.setText("");
                Toast.makeText(UserGuideActivity.this, "Thank you for your message!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_1.setTypeface(tf);
        et_1 = findViewById(R.id.et_1);
        et_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("Edit Text:", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_1.setTypeface(tf);


        userguide = findViewById(R.id.userguide);
        mainpage = findViewById(R.id.mainpage);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(mainpage, ViewCompat.getTransitionName(mainpage));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(UserGuideActivity.this, pair1);
                Intent intent = new Intent(UserGuideActivity.this, HomePageActivity.class);
                ActivityCompat.startActivity(UserGuideActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });
        notification = findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(notification, ViewCompat.getTransitionName(notification));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(UserGuideActivity.this, pair1);
                Intent intent = new Intent(UserGuideActivity.this, AlertsActivity.class);
                ActivityCompat.startActivity(UserGuideActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair1 = new Pair<>(account, ViewCompat.getTransitionName(account));
                Pair pair2 = new Pair<>(userguide, ViewCompat.getTransitionName(userguide));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(UserGuideActivity.this, pair1, pair2);
                Intent intent = new Intent(UserGuideActivity.this, AccountActivity.class);
                ActivityCompat.startActivity(UserGuideActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);
    }
}