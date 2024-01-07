package com.example.caats.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.caats.R;

public class MainActivity extends AppCompatActivity {



    Button btn_random_generate;
    Button btn_tag_generate;
    Button btn_random_text_generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_random_generate = findViewById(R.id.btn_random);
        btn_tag_generate = findViewById(R.id.btn_tag);
        btn_random_text_generate = findViewById(R.id.btn_random_text);

        btn_random_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(RandomActivity.class);
            }
        });


        btn_tag_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(TagActivity.class);
            }
        });

        btn_random_text_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(RandomWithTextActivity.class);
            }
        });
    }

    public void changeActivity(Class activity){
        Intent i = new Intent(getApplicationContext(), activity);
        startActivity(i);

    }
}