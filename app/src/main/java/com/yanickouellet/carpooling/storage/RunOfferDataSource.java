package com.yanickouellet.carpooling.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yanickouellet.carpooling.models.RunOffer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RunOfferDataSource {
    private static final String TABLE = "run_offers";
    private static final String ID = "id";
    private static final String FROM_ADDRESS = "fromAddress";
    private static final String TO_ADDRESS = "toAddress";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String PONCTUAL = "ponctual";
    private static final String DAY_OF_WEEK = "dayOfWeek";
    private static final String DATE = "date";
    private static final String PLACES = "places";
    private static final String KM_VALUE = "kmValue";
    private static final String DATE_SAVE_FORMAT = "yyyy-MM-dd";

    private DatabaseOpenHelper mHelper;

    public RunOfferDataSource(Context context) {
        mHelper = new DatabaseOpenHelper(context);
    }

    public void InsertRunOffer(RunOffer offer) {
        SQLiteDatabase db = mHelper.getWritableDatabase();

        db.insert(TABLE, null, makeContentValues(offer));

        db.close();
    }

    public ArrayList<RunOffer> FetchAll() {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE, null);
        ArrayList<RunOffer> offers = new ArrayList<>();

        while(cursor.moveToNext()) {
            offers.add(makeRunOffer(cursor));
        }

        db.close();
        cursor.close();

        return offers;
    }

    private static RunOffer makeRunOffer(Cursor c) {
        RunOffer req = new RunOffer();

        req.setId(c.getInt(c.getColumnIndex(ID)));
        req.setFromAddress(c.getString(c.getColumnIndex(FROM_ADDRESS)));
        req.setToAddress(c.getString(c.getColumnIndex(TO_ADDRESS)));
        req.setPlaces(c.getInt(c.getColumnIndex(PLACES)));
        req.setKmValue(c.getInt(c.getColumnIndex(KM_VALUE)));
        req.setHour(c.getInt(c.getColumnIndex(HOUR)));
        req.setMinute(c.getInt(c.getColumnIndex(MINUTE)));
        req.setPoncutal(c.getInt(c.getColumnIndex(PONCTUAL)) == 1);
        req.setDayOfWeek(c.getInt(c.getColumnIndex(DAY_OF_WEEK)));

        String stringDate = c.getString(c.getColumnIndex(DATE));
        if (stringDate == null) {
            req.setDate(null);
        } else {
            SimpleDateFormat format = new SimpleDateFormat(DATE_SAVE_FORMAT);
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(format.parse(stringDate));
                req.setDate(cal);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return req;
    }

    private static ContentValues makeContentValues(RunOffer offer) {
        ContentValues values = new ContentValues();

        values.put(FROM_ADDRESS, offer.getFromAddress());
        values.put(TO_ADDRESS, offer.getToAddress());
        values.put(PLACES, offer.getPlaces());
        values.put(KM_VALUE, offer.getKmValue());
        values.put(HOUR, offer.getHour());
        values.put(MINUTE, offer.getMinute());
        values.put(PONCTUAL, offer.isPoncutal());
        values.put(DAY_OF_WEEK, offer.getDayOfWeek());
        if (offer.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat(DATE_SAVE_FORMAT);
            values.put(DATE, format.format(offer.getDate().getTime()));
        }
        else
            values.putNull(DATE);

        return values;
    }
}
