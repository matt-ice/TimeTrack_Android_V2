package com.example.timetrack_android_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Matus on 21. 5. 2014.
 */
public class DBHandler {

    public static abstract class DBFeeder implements BaseColumns{
        public static final String TABLE_NAME = "TimeTravel";
        public static final String COLUMN_NAME_DATE = "Date";
        public static final String COLUMN_NAME_USER = "User";
        public static final String COLUMN_NAME_PUNCH_IN = "Punch In";
        public static final String COLUMN_NAME_PUNCH_OUT = "Punch Out";
        public static final String COLUMN_NAME_REQ_TIME = "Required Time";
        public static final String COLUMN_NAME_LUNCH = "Lunch";

    }
    private static final String COMMA = ", ";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = "INTEGER";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + DBFeeder.TABLE_NAME + "(" + DBFeeder._ID + " INTEGER PRIMARY KEY, " + DBFeeder.COLUMN_NAME_DATE + TEXT_TYPE + COMMA +
            DBFeeder.COLUMN_NAME_USER + TEXT_TYPE + DBFeeder.COLUMN_NAME_PUNCH_IN + INT_TYPE + COMMA + DBFeeder.COLUMN_NAME_PUNCH_OUT + INT_TYPE + COMMA + DBFeeder.COLUMN_NAME_REQ_TIME + INT_TYPE +
            COMMA + DBFeeder.COLUMN_NAME_LUNCH + INT_TYPE + ")";
    public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + DBFeeder.TABLE_NAME;



    public class DBFeederHelper extends SQLiteOpenHelper{
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "TimeTrack.db";
        public DBFeederHelper (Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db){
            db.execSQL(SQL_CREATE_TABLE);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL(SQL_DELETE_TABLE);
        }


    }


}

