package com.yanickouellet.carpooling.storage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "carpooling";
    public static final String RUN_REQUESTS_NAME = "run_requests";
    public static final String RUN_OFFERS_NAME = "run_offers";

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RUN_REQUESTS_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + RUN_OFFERS_NAME + ";");
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + RUN_REQUESTS_NAME + " (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        " fromAddress TEXT, toAddress TEXT, hour INTEGER, minute INTEGER, " +
                        " ponctual INTEGER, dayOfWeek INTEGER, date DATETIME);"
        );

        db.execSQL(
                "CREATE TABLE " + RUN_OFFERS_NAME + " (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        " fromAddress TEXT, toAddress TEXT, hour INTEGER, minute INTEGER, " +
                        " ponctual INTEGER, dayOfWeek INTEGER, date DATETIME," +
                        " places INTEGER, kmValue INTEGER);"
        );
    }
}
