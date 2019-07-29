package com.shirucodes.angaza.SplashView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shirucodes.angaza.R;

public class StartScreen extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        floatingActionButton = findViewById(R.id.fab1);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(StartScreen.this,StartScreen2.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);
    }

    public void next(View view) {
       Intent intent = new Intent(StartScreen.this, StartScreen2.class);
       startActivity(intent);
    }
}
