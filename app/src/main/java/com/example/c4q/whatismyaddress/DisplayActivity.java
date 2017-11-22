package com.example.c4q.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private String intentString;
    private TextView displayText01;
    private TextView displayText02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent= getIntent();
        intentString=intent.getStringExtra("hey");

        displayText01= (TextView) findViewById(R.id.dt1);
        displayText02=(TextView) findViewById(R.id.dt2);
        displayText01.setText(intentString);
        int stringLength=intentString.length();
        displayText02.setText(Integer.parseInt(intentString));
    }
}
