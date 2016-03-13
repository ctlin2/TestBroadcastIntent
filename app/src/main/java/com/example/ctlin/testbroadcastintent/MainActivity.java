package com.example.ctlin.testbroadcastintent;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnRegisterReceiver,
                mBtnUnregisterReceiver,
                mBtnSendBroadcast1,
                mBtnSendBroadcast2;

    private MyBroadcastReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupViewComponent();
    }

    private void setupViewComponent(){
        mBtnRegisterReceiver = (Button)findViewById(R.id.btnRegReceiver);
        mBtnUnregisterReceiver = (Button)findViewById(R.id.btnUnregReceiver);
        mBtnSendBroadcast1 = (Button)findViewById(R.id.btnSendBroadcast1);
        mBtnSendBroadcast2 = (Button)findViewById(R.id.btnSendBroadcast2);

        // 設定按鈕事件監聽方法
        mBtnRegisterReceiver.setOnClickListener(btnRegReceiverOnClickListener);
        mBtnUnregisterReceiver.setOnClickListener(btnUnregReceiverOnClickListener);
        mBtnSendBroadcast1.setOnClickListener(btnBtnSendBroadcast1OnClickListener);
        mBtnSendBroadcast2.setOnClickListener(btnBtnSendBroadcast2OnClickListener);
    }

    private Button.OnClickListener btnRegReceiverOnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            IntentFilter itFilter = new IntentFilter("tw.edu.ksu.ie.MY_BROADCAST1");
            mMyReceiver = new MyBroadcastReceiver();
            registerReceiver(mMyReceiver, itFilter);
            Log.e("ctlin", "RegisterReceiver");
        }
    };

    private Button.OnClickListener btnUnregReceiverOnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            unregisterReceiver(mMyReceiver);
            Log.e("ctlin", "UnregisterReceiver");
        }
    };

    private Button.OnClickListener btnBtnSendBroadcast1OnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent("tw.edu.ksu.ie.MY_BROADCAST1");
            intent.putExtra("sender_name", "主程式");
            sendBroadcast(intent);
            Log.e("ctlin", "SendBroadcast1");
        }
    };

    private Button.OnClickListener btnBtnSendBroadcast2OnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent("tw.edu.ksu.ie.MY_BROADCAST2");
            intent.putExtra("sender_name", "主程式");
            sendBroadcast(intent);
            Log.e("ctlin", "SendBroadcast2");
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
