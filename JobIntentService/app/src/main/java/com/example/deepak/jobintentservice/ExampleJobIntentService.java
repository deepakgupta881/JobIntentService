package com.example.deepak.jobintentservice;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class ExampleJobIntentService extends JobIntentService {
    private static final String TAG = ExampleJobIntentService.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "on Create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, ExampleJobIntentService.class, 1, work);
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStop current work");
        return super.onStopCurrentWork();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        String input = intent.getStringExtra("input");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "run " + input + i);
            if (isStopped()) return;
            SystemClock.sleep(1000);
        }

    }
}
