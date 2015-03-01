package com.yanickouellet.carpooling.presenters;

import android.content.Context;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.models.BaseRun;

import java.util.Calendar;

public class DatePresenter {
    public static String presentRunDate(BaseRun run, Context context) {
        String text = "";

        if (run.isPoncutal()) {
            Calendar date = run.getDate();
            text += date.get(Calendar.DAY_OF_MONTH) + " " +
                    date.getDisplayName(Calendar.MONTH, Calendar.LONG, context.getResources().getConfiguration().locale);
        } else {
            text += context.getResources().getStringArray(R.array.days_of_week)[run.getDayOfWeek()];
        }

        text += " " + run.getHour() + "H" + run.getMinute();

        return text;
    }
}
