package com.yanickouellet.carpooling.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yanickouellet.carpooling.models.RunRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RunRequestDataSource {
    private static final String TABLE = "run_requests";
    private static final String ID = "id";
    private static final String FROM_ADDRESS = "fromAddress";
    private static final String TO_ADDRESS = "toAddress";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String PONCTUAL = "ponctual";
    private static final String DAY_OF_WEEK = "dayOfWeek";
    private static final String DATE = "date";
    private static final String DATE_SAVE_FORMAT = "yyyy-MM-dd";

    private DatabaseOpenHelper mHelper;

    public RunRequestDataSource(Context context) {
        mHelper = new DatabaseOpenHelper(context);
    }

    public void InsertRunRequest(RunRequest request) {
        SQLiteDatabase db = mHelper.getWritableDatabase();

        db.insert(TABLE, null, makeContentValues(request));

        db.close();
    }

    public ArrayList<RunRequest> FetchAll() {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE, null);
        ArrayList<RunRequest> requests = new ArrayList<>();

        while(cursor.moveToNext()) {
            requests.add(makeRunRequest(cursor));
        }

        db.close();
        cursor.close();

        return requests;
    }

    private static RunRequest makeRunRequest(Cursor c) {
        RunRequest req = new RunRequest();

        req.setId(c.getInt(c.getColumnIndex(ID)));
        req.setFromAddress(c.getString(c.getColumnIndex(FROM_ADDRESS)));
        req.setToAddress(c.getString(c.getColumnIndex(TO_ADDRESS)));
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

    private static ContentValues makeContentValues(RunRequest request) {
        ContentValues values = new ContentValues();

        values.put(FROM_ADDRESS, request.getFromAddress());
        values.put(TO_ADDRESS, request.getToAddress());
        values.put(HOUR, request.getHour());
        values.put(MINUTE, request.getMinute());
        values.put(PONCTUAL, request.isPoncutal());
        values.put(DAY_OF_WEEK, request.getDayOfWeek());
        if (request.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat(DATE_SAVE_FORMAT);
            values.put(DATE, format.format(request.getDate().getTime()));
        }
        else
            values.putNull(DATE);

        return values;
    }
}
