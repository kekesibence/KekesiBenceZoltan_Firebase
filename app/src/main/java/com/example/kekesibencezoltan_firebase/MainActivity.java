package com.example.kekesibencezoltan_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnList, btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnList.setOnClickListener(view -> {
            Intent listIntent = new Intent(this, ListResultActivity.class);
            startActivity(listIntent);
            finish();
        });

        btnInsert.setOnClickListener(view -> {
            Intent insertIntent = new Intent(this, InsertActivity.class);
            startActivity(insertIntent);
            finish();
        });
    }

    private void init() {
        btnList = findViewById(R.id.btnList);
        btnInsert = findViewById(R.id.btnInsert);
    }
}