package com.shirucodes.angaza.database.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.shirucodes.angaza.database.databasecontacts.DatabaseContract;

import static android.content.ContentValues.TAG;


public class AngazaDatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Angaza.db";
    private static final int DATABASE_VERSION = 1;

    public AngazaDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate db: " + DatabaseContract.SQL_CREATE_RECENT_VERIFICATION_TABLE);
        db.execSQL(DatabaseContract.SQL_CREATE_RECENT_VERIFICATION_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DatabaseContract.SQL_DELETE_RECENT_VERIFICATION_TABLE);
        onCreate(database);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
