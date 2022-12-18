package com.kelompok_6.mentalhealthcare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class callActivity extends AppCompatActivity {

    Button call;
    Number number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        String number = "021-500-454";
        call = (Button) findViewById(R.id.caling);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toCall = "tel:"+number.toString();
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toCall)));
            }
        });
    }
}