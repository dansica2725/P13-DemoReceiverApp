package com.dansica.demoreceiverapp;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dansica.receiverapp.R;

public class MainActivity extends AppCompatActivity {

    BatteryReceiver batteryReceiver = new BatteryReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.BATTER_LOW");
        this.registerReceiver(batteryReceiver, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(batteryReceiver);
    }
}
