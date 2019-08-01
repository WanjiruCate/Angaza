package com.shirucodes.angaza.SplashView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.shirucodes.angaza.R;
import com.shirucodes.angaza.database.databasecontacts.DatabaseContract;
import com.shirucodes.angaza.database.helpers.AngazaDatabaseOpenHelper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Log.e("Tag", "onCreate: " + DatabaseContract.SQL_CREATE_RECENT_VERIFICATION_TABLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreen.this, StartScreen.class);

                startActivity(mainIntent);
                finish();
            }
        }, 3000);
    }
}
