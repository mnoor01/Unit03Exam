package com.example.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private Button button1;
    private Button button2;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput =(EditText) findViewById(R.id.etext01);
        button1=(Button) findViewById(R.id.button_save);
        button2=(Button) findViewById(R.id.button_two);

        SharedPreferences sharedPreferences=getApplication().getSharedPreferences("address_shared_preferences",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String input= userInput.getText().toString();

            editor.putString(input,input);
            editor.apply();
            editor.commit();
            userInput.setText("");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecyclerActivity.class);
                intent.putExtra("sharedpref","address_shared_preferences");
                startActivity(intent);
            }
        });
    }
}
