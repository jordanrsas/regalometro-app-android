package com.mireagaloideal.apportame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mireagaloideal.apportame.login.controllers.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);
                startActivity(intent);
                LaunchActivity.this.finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 2000);

    }
}
