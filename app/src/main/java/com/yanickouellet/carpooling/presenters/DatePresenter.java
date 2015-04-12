package com.yanickouellet.carpooling.presenters;

import android.content.Context;

import com.yanickouellet.carpooling.R;

import java.util.Calendar;

import none.carpooling.model.RunOffer;
import none.carpooling.model.RunRequest;

public class DatePresenter {
    public static String presentRequestDate(RunRequest run, Context context) {
        String text = "";

        if (run.getPonctual()) {
            //Calendar date = run.getDate();
            //text += date.get(Calendar.DAY_OF_MONTH) + " " +
            //        date.getDisplayName(Calendar.MONTH, Calendar.LONG, context.getResources().getConfiguration().locale);
            text+= run.getDate();
        } else {
            text += context.getResources().getStringArray(R.array.days_of_week)[run.getDayOfWeek().intValue()];
        }

        text += " " + run.getHour() + "H" + run.getMinute();

        return text;
    }

    public static String presentOfferDate(RunOffer run, Context context) {
        String text = "";

        if (run.getPonctual()) {
            //Calendar date = run.getDate();
            //text += date.get(Calendar.DAY_OF_MONTH) + " " +
            //        date.getDisplayName(Calendar.MONTH, Calendar.LONG, context.getResources().getConfiguration().locale);
            text+= run.getDate();
        } else {
            text += context.getResources().getStringArray(R.array.days_of_week)[run.getDayOfWeek().intValue()];
        }

        text += " " + run.getHour() + "H" + run.getMinute();

        return text;
    }
}
