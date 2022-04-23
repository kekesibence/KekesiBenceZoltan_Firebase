package com.example.kekesibencezoltan_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity  extends AppCompatActivity {
    private Button btnBack, btnAdd;
    private EditText editName, editCountry, editPopulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        init();

        btnBack.setOnClickListener(view -> {
            Intent backIntent = new Intent(this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });
    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBackFromInsert);
        editName = findViewById(R.id.editTextVarosNev);
        editCountry = findViewById(R.id.editTextVarosOrszag);
        editPopulation =findViewById(R.id.editTextLakossag);
    }
}
