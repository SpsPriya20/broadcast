package com.priya.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BroadcastActivity extends AppCompatActivity {

    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
                Toast.makeText(BroadcastActivity.this,"working",Toast.LENGTH_SHORT).show();
            }
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)){
                Toast.makeText(BroadcastActivity.this,"Headset plugin",Toast.LENGTH_SHORT).show();
            }
            if (intent.getAction().equals("offer received")){
                Toast.makeText(BroadcastActivity.this,"my Action",Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);


    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter =new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction("offer received");
        registerReceiver(receiver,filter);

        Intent send =new Intent("offer received");
        sendBroadcast(send);


    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
