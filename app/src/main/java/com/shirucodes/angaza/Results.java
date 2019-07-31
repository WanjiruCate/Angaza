package com.shirucodes.angaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;

public class Results extends AppCompatActivity {

    WebView load_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        load_result = findViewById(R.id.load_results);
        retrieveInfo();

        load_result.loadUrl("https://stl-v2.herokuapp.com/api/v2/get?url=" + retrieveInfo());
    }

    public String retrieveInfo() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("database", Context.MODE_PRIVATE);
        String link = sharedPref.getString("link", "");
        return link;
    }
}
