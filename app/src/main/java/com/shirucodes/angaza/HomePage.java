package com.shirucodes.angaza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.shirucodes.angaza.adapters.HistoryAdapter;
import com.shirucodes.angaza.models.Verification;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;

public class HomePage extends AppCompatActivity {

    TextView paste;
    ClipboardManager clipboardManager;
    RecyclerView recyclerView;
    ArrayList<Verification> verifications = new ArrayList<>();
    HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        paste = findViewById(R.id.txt_paste);
        recyclerView = findViewById(R.id.recentsearchRecyclerview);
        adapter = new HistoryAdapter(verifications);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Verification v = new Verification("30th July 2019", "Devox releases a new version of ubuntu");
        Verification v2 = new Verification("30th July 2019", "Devox releases a new version of ubuntu");
        verifications.add(v);
        verifications.add(v2);
        adapter.notifyDataSetChanged();


        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if (!clipboardManager.hasPrimaryClip()) {
            paste.setEnabled(false);
            Toast.makeText(HomePage.this, "Kindly copy a link to proceed to verification",
                    Toast.LENGTH_LONG).show();
        }


    }

    public void paste_link(View view) {
        ClipData clipData = clipboardManager.getPrimaryClip();
        ClipData.Item item = clipData.getItemAt(0);

        paste.setText(item.getText().toString());

        Toast.makeText(HomePage.this, "We have accessed your copied link ' " + item.getText().toString() + " .' Kindly give us a moment to run it against our model"
                , Toast.LENGTH_LONG).show();
    }
}