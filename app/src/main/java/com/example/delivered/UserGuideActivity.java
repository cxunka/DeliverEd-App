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
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
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
    private TextView tv_1,tv_3,link;
    private EditText et_1;

    private static final String[] strs = new String[] {
            "\n1. Simple Parcel Drop-Offs for Couriers\n\n    We have ensured that our mailboxes are simple and efficient for couriers to use, as we recognise that they are on tight schedules and don’t have time to mess with a complicated device.Couriers simply push a clearly labelled button on the mailbox, which opens the drop-off compartment.\n",
            "\n2. Real-Time App Notifications\n\n    Real-time alerts from our DeliverEd app tell you everything you need to know about your mailbox. We let you know immediately when a parcel has arrived, when your device is low on charge, and when your mailbox is full. Our app also provides multiple security alerts, so you can rest easy knowing your parcels will be safe when you return home.\n",
            "\n3. Device Locking\n\n    All devices come with the option to lock the drop-off compartment, preventing anyone from delivering anything to your mailbox. This can be useful for when you are not expecting any deliveries, and also automatically occurs when your mailbox is full.\n",
            "\n4. Intuitive Device Interaction\n\n    The primary interactions you will have with our mailboxes will be to lock and unlock them. We have ensured that performing these actions is a simple and intuitive process, taking accessibility and usability into heavy consideration. The device doors can be controlled with the push of a clearly labelled button on our App.\n",
            "\n5. Secure Parcel Compartment Separate from Delivery Compartment\n\n    Once a parcel has been dropped into the mailbox by a courier, it is transferred into a separate secure compartment, only accessible via our DeliverEd app. This prevents any previously delivered parcels from being removed during delivery.\n",
            "\n6. UV Parcel Sanitation\n\n    The secure compartment of each device comes with safe built-in UV light, which effectively sanitises your parcels without damaging them.\n",
            "\n7. Long Battery Life\n\n    All DeliverEd devices come with a long-lasting battery, and an in-built safety mechanism to ensure that even if your device runs out of charge, your parcels will be protected. An electromagnetic lock ensures that upon power failure, the mailbox remains locked, rather than unlocked. Our app will notify you when your battery is low, and we provide cheap and easy battery replacement services, so you won’t be caught off guard.\n",
            "\n8. Simple Device Ownership Customization\n\n    In the event that you are away from home for extended periods of time, we recognise that it may be necessary for someone else to collect your parcels for you. Both for this reason, and to accommodate shared households, we have implemented shared mailboxes. You can easily add and remove other registered DeliverEd customers from your device’s permissions, enabling them to open and close your device via the App on their own mobile device.\n",
            "\n9. Tamper Proof Devices\n\n    All our devices are made of tough materials, making them both tamper and weather resistant. Our mailboxes fit securely to your wall or floor, and this coupled with real-time security alerts via our App gives you what we hope to be total confidence in the safety of your parcels. "
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

        link = findViewById(R.id.link);

        SpannableString ss = new SpannableString("For more information, go to our WebPage to find more.");
        ss.setSpan(new URLSpan("https://group19.sdp.inf.ed.ac.uk/user-guide.html"), 32, 39,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        link.setText(ss);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link.setTypeface(tf);

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
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                ActivityCompat.startActivity(UserGuideActivity.this, intent, transitionActivityOptions.toBundle());
            }
        });

        home = findViewById(R.id.home);
        home.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        home.setTypeface(tf);
    }
}