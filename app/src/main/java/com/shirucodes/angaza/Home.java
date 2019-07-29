package com.shirucodes.angaza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shirucodes.angaza.ui.home.HomeFragment;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow();
        }
    }
}
