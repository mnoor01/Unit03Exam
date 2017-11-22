package com.example.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Intent intent=getIntent();
        sharedPreferences= getApplicationContext().getSharedPreferences(intent.getStringExtra("sharedpref"),MODE_PRIVATE);
        Map<String, ?> allEntry=sharedPreferences.getAll();
        for (String entry: allEntry.keySet()){
            ArrayList<String> values= new ArrayList<>();
            values.add(entry);

            }
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.test_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(values);




    }
    public void clickedview(View view){
        Intent intent= new Intent(RecyclerActivity.this,DisplayActivity.class);
        intent.putExtra("hey","nice");
        startActivity(intent);

    }
}
