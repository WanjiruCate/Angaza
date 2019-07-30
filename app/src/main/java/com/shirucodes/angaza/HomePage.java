package com.shirucodes.angaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    TextView paste;
    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        paste = findViewById(R.id.txt_paste);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if (!clipboardManager.hasPrimaryClip()){
            paste.setEnabled(false);
            Toast.makeText(HomePage.this,"Kindly copy a link to proceed to verification",
                    Toast.LENGTH_LONG).show();
        }




    }

    public void paste_link(View view) {
        ClipData clipData = clipboardManager.getPrimaryClip();
        ClipData.Item item = clipData.getItemAt(0);

        paste.setText(item.getText().toString());

        Toast.makeText(HomePage.this,"We have accessed your copied link ' "+ item.getText().toString() +" .' Kindly give us a moment to run it against our model"
                , Toast.LENGTH_LONG).show();
    }
}
