package com.shirucodes.angaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.shirucodes.angaza.adapters.ApiResultAdapter;
import com.shirucodes.angaza.database.databasecontacts.DatabaseContract;
import com.shirucodes.angaza.database.helpers.AngazaDatabaseOpenHelper;
import com.shirucodes.angaza.http.HttpRequests;
import com.shirucodes.angaza.json.ResponseDiserializer;
import com.shirucodes.angaza.models.Paragraph;
import com.shirucodes.angaza.models.Verification;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    WebView load_result;
    String newsUrl;

    private SQLiteDatabase angazaDatabase;
    private SQLiteOpenHelper dbOpenHelper;
    private String TAG = "";
    RecyclerView recyclerView;
    ApiResultAdapter adapter;
    ArrayList<Paragraph> paragraphArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        dbOpenHelper = new AngazaDatabaseOpenHelper(getApplicationContext());
        angazaDatabase = dbOpenHelper.getWritableDatabase();
        load_result = findViewById(R.id.load_results);
        newsUrl = new Intent().getStringExtra("news_link");

        new FetchApiResultTask().execute();//load the api results in background while progress rotates

//        retrieveInfo();
        load_result.loadUrl("https://stl-v2.herokuapp.com/api/v2/get?url=" + newsUrl);


        adapter = new ApiResultAdapter(paragraphArrayList);
        cacheVerificationDetails(); // store the recent verifications on local database

    }

//    public String retrieveInfo() {
//        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("database", Context.MODE_PRIVATE);
//        String link = sharedPref.getString("link", "");
//        return link;
//    }

    public void cacheVerificationDetails() {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.RECENT_VERIFICATION_ENTRY.COLUMN_NAME_ARTICLE_LINK, newsUrl);
        contentValues.put(DatabaseContract.RECENT_VERIFICATION_ENTRY.COLUMN_NAME_VERIFICATION_DATE, "1-08-2019");


        long rowId = angazaDatabase.insertOrThrow(DatabaseContract.RECENT_VERIFICATION_ENTRY.TABLE_NAME, null, contentValues);

    }

    public class FetchApiResultTask extends AsyncTask<Void, Void, Void> {

        @SuppressLint("LongLogTag")
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            displayProgressDialog("Verifying article ...");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            StringBuffer rawApiResultBuffer = HttpRequests.getRawVerificationResult(newsUrl);

            if (rawApiResultBuffer != null) {

                paragraphArrayList.clear();
                for (Paragraph paragraph : ResponseDiserializer.deserializeVerificationResult(rawApiResultBuffer)) {
                    paragraphArrayList.add(paragraph);
                    Log.e(TAG, "doInBackground: paragraph score" + paragraph.getParagraphScore());
                }
            } else {
                Log.e(TAG, "doInBackground: buffer null");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
//            progressDialog.dismiss();
//            adapter.notifyDataSetChanged();

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        angazaDatabase.close();
    }
}
