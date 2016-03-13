package com.example.ctlin.testbroadcastintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ctlin on 2016/3/12.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String sender = intent.getStringExtra("sender_name");
        Toast.makeText(context,"Receiver收到"+sender+"廣播訊息", Toast.LENGTH_LONG);
        Log.e("LOG_TAG", "Receiver收到" + sender + "廣播訊息");
    }
}

