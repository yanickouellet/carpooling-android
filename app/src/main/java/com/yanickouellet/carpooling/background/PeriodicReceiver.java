package com.yanickouellet.carpooling.background;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class PeriodicReceiver extends BroadcastReceiver {

    public PeriodicReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent serviceIntent = new Intent(context, PullDataService.class);
            PendingIntent alarmIntent = PendingIntent.getService(context, 0, serviceIntent, 0);
            AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

            alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),
                    30 * 60 * 1000, // Repeat every 30 minutes
                    alarmIntent);
        }
    }
}
